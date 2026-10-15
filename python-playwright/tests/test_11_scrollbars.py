import pytest
from config import BASE_URL
from playwright.sync_api import Page, expect


@pytest.mark.regression
def test_scrollbars(page: Page):
    page.goto(f"{BASE_URL}/scrollbars")
    page.click("#hidingButton")
    expect(page.locator("#hidingButton")).to_be_in_viewport()