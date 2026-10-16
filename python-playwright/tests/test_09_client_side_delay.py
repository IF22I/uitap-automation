import pytest
from config import BASE_URL
from playwright.sync_api import Page, expect


@pytest.mark.smoke
@pytest.mark.regression
def test_client_side_delay(page: Page):
    page.goto(f"{BASE_URL}/clientdelay")
    page.click("#ajaxButton")
    expect(page.locator("#content p")).to_have_text("Data calculated on the client side.", timeout=20000)