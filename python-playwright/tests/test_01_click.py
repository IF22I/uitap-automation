import re

import pytest
from playwright.sync_api import Page, expect


@pytest.mark.regression
def test_click_button(page: Page):
    page.goto("http://uitestingplayground.com/click")
    page.click("#badButton")
    expect(page.locator("#badButton")).to_have_class(re.compile(r"btn-success"))