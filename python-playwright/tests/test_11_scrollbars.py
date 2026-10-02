import pytest
from playwright.sync_api import Page, expect


@pytest.mark.regression
def test_scrollbars(page: Page):
    page.goto("http://uitestingplayground.com/scrollbars")
    page.click("#hidingButton")
    expect(page.locator("#hidingButton")).to_be_in_viewport()