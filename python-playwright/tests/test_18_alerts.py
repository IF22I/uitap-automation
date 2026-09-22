import pytest
from playwright.sync_api import Page

@pytest.mark.smoke
def test_alerts(page: Page):
    page.goto("http://uitestingplayground.com/alerts")

    last_message = None

    def handle_dialog(dialog):
        print(f"Dialog appeared: type={dialog.type}, message={dialog.message}")
        nonlocal last_message
        last_message = dialog.message
        if dialog.type == "prompt":
            dialog.accept("my answer")
        else:
            dialog.accept()

    page.on("dialog", handle_dialog)
    page.click("#alertButton")
    page.click("#confirmButton")
    page.click("#promptButton")

    assert "User value: my answer" in last_message