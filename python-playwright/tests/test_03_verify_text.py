import pytest
from config import BASE_URL
from playwright.sync_api import expect


@pytest.mark.smoke
@pytest.mark.regression 
def test_verify_text(page):
    page.goto(f"{BASE_URL}/verifytext")
    expect(page.locator(".bg-primary .badge-secondary")).to_have_text("Welcome UserName!")