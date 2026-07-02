from playwright.sync_api import expect

def test_dynamic_id(page):
    page.goto("http://uitestingplayground.com/dynamicid")
    button = page.get_by_role("button", name="Button with Dynamic ID")
    expect(button).to_be_visible()
    button.click()
