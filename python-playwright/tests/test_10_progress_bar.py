import pytest
from config import BASE_URL
from playwright.sync_api import Page

TARGET = 75
TOLERANCE = 3


@pytest.mark.regression
def test_progress_bar(page: Page):
    page.goto(f"{BASE_URL}/progressbar")
    page.click("#startButton")

       # The bar's speed is random per page load (75% reached in 1.4 s to 25 s).
       # Detecting in the browser, then clicking from Python, overshot on fast bars (stopped at 81-82%).
       # So detection and the Stop click run in the same animation frame.
       # Trade-off: the JS click skips Playwright's actionability checks; acceptable here.

    page.evaluate(
        """target => new Promise((resolve, reject) => {
            const bar = document.querySelector('#progressBar');
            const stop = document.querySelector('#stopButton');
            const deadline = performance.now() + 60000;
            const check = () => {
                if (Number(bar.getAttribute('aria-valuenow')) >= target) {
                    stop.click();
                    resolve();
                } else if (performance.now() > deadline) {
                    reject(new Error(`Progress bar never reached ${target}%`));
                } else {
                    requestAnimationFrame(check);
                }
            };
            check();
        })""",
        TARGET,
    )


    final = int(page.locator("#progressBar").get_attribute("aria-valuenow"))
    assert abs(final - TARGET) <= TOLERANCE, f"Stopped at {final}%, target {TARGET}% (tolerance {TOLERANCE})"