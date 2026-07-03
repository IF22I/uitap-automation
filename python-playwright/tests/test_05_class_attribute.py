from playwright.sync_api import expect

def test_class_attrribute(page):
    page.goto("http://uitestingplayground.com/classattr")
    button = page.locator("button.btn-primary")
    expect(button).to_be_visible()
    button.click() 