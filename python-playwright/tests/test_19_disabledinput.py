import pytest
from playwright.sync_api import Page, expect


@pytest.mark.smoke
def test_disabled_input(page: Page):
    page.goto("http://uitestingplayground.com/disabledinput")
    # page.fill("#inputField", "first_text_input")
    # print("Is enabled right before click:", page.locator("#inputField").is_enabled())
    page.click("#enableButton")
    # print("Is enabled right after click:", page.locator("#inputField").is_enabled())
    expect(page.locator("#inputField")).to_be_enabled(timeout=15000)
    page.fill("#inputField", "second_text_input")
    page.locator("#inputField").blur()
    # page.locator("#opstatus").click()
    expect(page.locator("#opstatus")).to_have_text("Value changed to: second_text_input")