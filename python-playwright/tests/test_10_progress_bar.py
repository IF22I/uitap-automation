import pytest
from config import BASE_URL
from playwright.sync_api import Page


@pytest.mark.regression
def test_progress_bar(page):
    page.goto(f"{BASE_URL}/progressbar")
    page.click("#startButton")

    while True:
        value = page.locator("#progressBar").get_attribute("aria-valuenow")
        current = int(value)
        if current >= 75:
            break

    page.click("#stopButton")
    difference = abs(current - 75)
    assert difference<=3, f"Stopped {difference}% away from the target"