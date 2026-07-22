from playwright.sync_api import Page
from playwright.sync_api import expect

def test_overlapped(page: Page):
    page.goto("http://uitestingplayground.com/overlapped")
    page.fill("#id", "test_id")
    page.click("#name")
    page.fill("#name", "test_name")
    expect(page.locator("#name")).to_have_value("test_name")
    expect(page.locator("#id")).to_have_value("test_id")