import pytest
from config import BASE_URL
from playwright.sync_api import Page, expect


@pytest.mark.regression
def test_nonbreakingspace(page: Page):
    page.goto(f"{BASE_URL}/nbsp")
    expect(page.get_by_text("My\u00A0Button", exact=True)).to_be_visible()