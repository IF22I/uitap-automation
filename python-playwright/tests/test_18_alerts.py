import pytest, time
from playwright.sync_api import Page

@pytest.mark.smoke
def test_alerts(page: Page):
    BASE_URL = "http://uitestingplayground.com"
    page.goto(f"{BASE_URL}/alerts")

    # --- 1. Alert Button ---
    # We use a context manager to wait for the dialog *while* clicking the button
    with page.expect_event("dialog") as alert_info:
        page.locator("#alertButton").click()
    
    alert = alert_info.value
    alert.accept()

    # --- 2. Confirm Button ---
    # Expect the initial confirm dialog
    with page.expect_event("dialog") as confirm_info:
        page.locator("#confirmButton").click()
        
    confirm = confirm_info.value

    # Accepting the confirm triggers a follow-up alert.
    # We wrap the accept() inside another expect_event to catch it!
    with page.expect_event("dialog") as follow_up_confirm_info:
        confirm.accept()
        
    follow_up_confirm = follow_up_confirm_info.value
    follow_up_confirm.accept()

    # --- 3. Prompt Button ---
    with page.expect_event("dialog") as prompt_info:
        page.locator("#promptButton").click()
        
    prompt = prompt_info.value

    # Pass the input text directly into accept(), and wait for the follow-up alert
    with page.expect_event("dialog") as follow_up_prompt_info:
        prompt.accept("my answer")
        
    follow_up_prompt = follow_up_prompt_info.value

    # Extract the text message from the dialog
    prompt_message = follow_up_prompt.message
    follow_up_prompt.accept()

    # --- Assert ---
    # Python's built-in assert replaces TestNG's Assert.assertTrue
    assert "my answer" in prompt_message, "Expected the follow-up alert to contain the entered prompt value"