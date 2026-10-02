import pytest
from playwright.sync_api import Page, expect


@pytest.mark.smoke
def test_disabled_input(page: Page):
    page.goto("http://uitestingplayground.com/disabledinput")

    page.click("#enableButton")

    expect(page.locator("#inputField")).to_be_enabled(timeout=15000)
    page.fill("#inputField", "second_text_input")
    page.locator("#inputField").blur()
  
    expect(page.locator("#opstatus")).to_have_text("Value changed to: second_text_input")