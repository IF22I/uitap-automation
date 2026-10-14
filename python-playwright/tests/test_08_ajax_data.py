import pytest
from playwright.sync_api import Page, expect


@pytest.mark.smoke
@pytest.mark.regression 
def test_ajax_data(page: Page):
    page.goto("http://uitestingplayground.com/ajax")
    page.click("#ajaxButton")
    expect(page.locator("#content p")).to_have_text("Data loaded with AJAX get request.", timeout=20000)