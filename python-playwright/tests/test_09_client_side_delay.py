import pytest
from playwright.sync_api import Page, expect


@pytest.mark.smoke
@pytest.mark.regression 
def test_client_side_delay(page: Page):
   page.goto("http://uitestingplayground.com/clientdelay")
   page.click("#ajaxButton")
   page.click("text=Data calculated on the client side.")
   expect(page.locator("#content p")).to_have_text("Data calculated on the client side.", timeout=20000)