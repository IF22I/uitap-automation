import pytest
from pages.login_page import LoginPage
from playwright.sync_api import Page


@pytest.mark.smoke          
@pytest.mark.regression 
def test_sample_app(page: Page):
    login_page = LoginPage(page)
    login_page.login("test_user", "pwd")
    assert login_page.get_status() == "Welcome, test_user!"