import pytest
from config import BASE_URL
from playwright.sync_api import expect


@pytest.mark.regression
def test_dynamic_id(page):
    page.goto(f"{BASE_URL}/dynamicid")
    button = page.get_by_role("button", name="Button with Dynamic ID")
    expect(button).to_be_visible()
    button.click()
