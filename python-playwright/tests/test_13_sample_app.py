from playwright.sync_api import Page
from playwright.sync_api import expect
from utils.helpers import login_as

def test_sample_app(page: Page):
    login_as(page, "test_user", "pwd")
    expect(page.locator("#loginstatus")).to_have_text("Welcome, test_user!")