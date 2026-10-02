import re

import pytest
from playwright.sync_api import Page, expect


@pytest.mark.smoke
@pytest.mark.regression 
def test_animated_button(page: Page):
    page.goto("http://uitestingplayground.com/animation")
    page.click("#animationButton")

    expect(page.locator("#movingTarget")).not_to_have_class(re.compile(r"spin"), timeout=10000)

    page.click("#movingTarget")
    expect(page.locator("#opstatus")).to_have_text("Moving Target clicked. It's class name is 'btn btn-primary'")