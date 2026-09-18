import pytest
from playwright.sync_api import Page


@pytest.mark.regression
def test_hiddenlayer(page: Page):

    page.goto("http://uitestingplayground.com/hiddenlayers")

    green_button = page.locator("#greenButton")
    
    box = green_button.bounding_box()
    center_x = box["x"] + box["width"] / 2
    center_y = box["y"] + box["height"] / 2

    top_element_before_id = page.evaluate("([x, y]) => document.elementFromPoint(x, y).id", [center_x, center_y])

    page.click("#" + top_element_before_id)

    top_element_after_id = page.evaluate("([x, y]) => document.elementFromPoint(x, y).id", [center_x, center_y])

    assert top_element_before_id != top_element_after_id




