from playwright.sync_api import Page
import pytest

@pytest.mark.regression
def test_scrollbars(page):
    page.goto("http://uitestingplayground.com/scrollbars")
    page.click("#hidingButton")