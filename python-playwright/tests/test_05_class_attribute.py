import pytest
from config import BASE_URL
from playwright.sync_api import expect


@pytest.mark.regression
def test_class_attribute(page):
    page.goto(f"{BASE_URL}/classattr")
    button = page.locator("button.btn-primary")
    expect(button).to_be_visible()
    button.click() 