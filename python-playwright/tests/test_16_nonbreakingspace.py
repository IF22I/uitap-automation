import pytest
from playwright.sync_api import Page, expect


@pytest.mark.regression
def test_nonbreakingspace(page: Page):
    page.goto("http://uitestingplayground.com/nbsp")
    expect(page.get_by_text("My\u00A0Button", exact=True)).to_be_visible()