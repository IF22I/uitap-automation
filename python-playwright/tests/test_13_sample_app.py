from playwright.sync_api import Page
from playwright.sync_api import expect

def test_sample_app(page: Page):
    page.goto("http://uitestingplayground.com/sampleapp")
    page.fill("[name='UserName']", "test_user")
    page.fill("[name='Password']", "pwd")
    page.click("#login")
    expect(page.locator("#loginstatus")).to_have_text("Welcome, test_user!")
    page.wait_for_timeout(5000)