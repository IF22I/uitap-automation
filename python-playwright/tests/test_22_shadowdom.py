import pytest
from config import BASE_URL
from playwright.sync_api import Page, expect


@pytest.mark.smoke
@pytest.mark.regression 
def test_shadowdom(page: Page):

    page.context.grant_permissions(["clipboard-read", "clipboard-write"])

    page.goto(f"{BASE_URL}/shadowdom")

    page.click("#buttonGenerate")
    page.click("#buttonCopy")

    clipboard_text = page.evaluate("navigator.clipboard.readText()")
  
    expect(page.locator("#editField")).to_have_value(clipboard_text)