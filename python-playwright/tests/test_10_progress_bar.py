import pytest
from config import BASE_URL
from playwright.sync_api import Page

TARGET = 75
TOLERANCE = 3


@pytest.mark.regression
def test_progress_bar(page: Page):
    page.goto(f"{BASE_URL}/progressbar")
    page.click("#startButton")

    page.wait_for_function(
        "target => Number(document.querySelector('#progressBar').getAttribute('aria-valuenow')) >= target",
        arg=TARGET,
        timeout=60_000,
    )
    page.click("#stopButton")
    
    final = int(page.locator("#progressBar").get_attribute("aria-valuenow"))
    assert abs(final - TARGET) <= TOLERANCE, f"Stopped at {final}%, target {TARGET}% (tolerance {TOLERANCE})"