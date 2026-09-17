import pytest
from playwright.sync_api import Page


@pytest.mark.smoke
def test_mouse_over(page: Page):

    page.goto("http://uitestingplayground.com/mouseover")

    click_me = page.get_by_text("Click me", exact=True)
    count = page.locator("#clickCount")

    start = int(count.inner_text())

    click_me.click()
    click_me.click()

    end = int(count.inner_text())

    assert end == start + 2