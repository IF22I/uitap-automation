import pytest
from config import BASE_URL
from playwright.sync_api import Page, expect


@pytest.mark.regression
def test_overlapped(page: Page):
    page.goto(f"{BASE_URL}/overlapped")
    page.fill("#id", "test_id")
    page.click("#name")
    page.fill("#name", "test_name")
    expect(page.locator("#name")).to_have_value("test_name")
    expect(page.locator("#id")).to_have_value("test_id")