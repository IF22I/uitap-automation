from playwright.sync_api import expect


def test_load_delay(page):
    page.goto("http://uitestingplayground.com/")
    page.get_by_role("link", name="Load Delay").click()
    page.get_by_role("button", name="Button Appearing After Delay").click()
    expect(page.get_by_role("button", name="Button Appearing After Delay")).to_be_visible()