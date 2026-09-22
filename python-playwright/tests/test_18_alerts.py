import pytest
from playwright.sync_api import Page

@pytest.mark.smoke
def test_alerts(page: Page):
    page.goto("http://uitestingplayground.com/alerts")

    page.on("dialog", lambda dialog: dialog.accept())
    page.click("#alertButton")






    #page.click("#confirmButton")






    #page.click("#promptButton")