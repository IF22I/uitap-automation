from playwright.sync_api import Page

def test_progress_bar(page):
    page.goto("http://uitestingplayground.com/progressbar")
    page.click("#startButton")

    while True:
        value = page.locator("#progressBar").get_attribute("aria-valuenow")
        current = int(value)
        if current >= 75:
            break

    page.click("#stopButton")
    diffrence = abs(current - 75)
    assert diffrence<=3, f"Stopped {diffrence}% away from the target"