from playwright.sync_api import expect
import pytest

@pytest.mark.smoke
def test_verify_text(page):
    page.goto("http://uitestingplayground.com/verifytext")
    expect(page.locator(".bg-primary .badge-secondary")).to_have_text("Welcome UserName!")