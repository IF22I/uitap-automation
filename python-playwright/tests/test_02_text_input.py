import re

import pytest
from config import BASE_URL
from playwright.sync_api import Page, expect


@pytest.mark.regression
def test_text_input(page: Page):
    page.goto(f"{BASE_URL}/textinput")
    page.fill("#newButtonName", "02_text_input")
    page.click("#updatingButton")
    expect(page.locator("#updatingButton")).to_have_text("02_text_input")