import re
from playwright.sync_api import Page
from playwright.sync_api import expect
import pytest

@pytest.mark.regression
def test_text_input(page: Page):
    page.goto("http://uitestingplayground.com/textinput")
    page.fill("#newButtonName", "02_text_input")
    page.click("#updatingButton")
    expect(page.locator("#updatingButton")).to_have_text("02_text_input")