import pytest
from playwright.sync_api import Page, expect


@pytest.mark.smoke
def test_shadowdom(page: Page):

    page.context.grant_permissions(["clipboard-read", "clipboard-write"])

    page.goto("http://uitestingplayground.com/shadowdom")

    page.click("#buttonGenerate")
    page.click("#buttonCopy")

    clipboard_text = page.evaluate("navigator.clipboard.readText()")
  
    expect(page.locator("#editField")).to_have_value(clipboard_text)