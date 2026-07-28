from playwright.sync_api import Page
from pages.login_page import LoginPage

def test_sample_app(page: Page):
    login_page = LoginPage(page)
    login_page.login("test_user", "pwd")
    assert login_page.get_status() == "Welcome, test_user!"