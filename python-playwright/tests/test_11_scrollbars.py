from playwright.sync_api import Page

def test_scrollbars(page):
    page.goto("http://uitestingplayground.com/scrollbars")
    page.click("#hidingButton")
    #page.wait_for_timeout(5000)