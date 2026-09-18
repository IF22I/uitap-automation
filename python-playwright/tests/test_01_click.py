import pytest
from playwright.sync_api import Page

@pytest.mark.regression
def test_click_button(page: Page):
    page.goto("http://uitestingplayground.com/click")
    page.click("#badButton")