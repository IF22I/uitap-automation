import re
from playwright.sync_api import Page

def test_click_button(page):
    page.goto("http://uitestingplayground.com/click")
    page.click("#badButton")
    #expect(page.locator("#badButton")).to_have_class(re.compile("btn-success"))