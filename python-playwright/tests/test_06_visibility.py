from playwright.sync_api import expect

def test_click_button(page):
    page.goto("http://uitestingplayground.com/visibility")
    page.click("#hideButton")

    expect(page.locator("#removedButton")).to_be_hidden()        
    expect.soft(page.locator("#zeroWidthButton")).to_be_hidden()
    expect.soft(page.locator("#displayNoneButton")).to_be_hidden()
    expect.soft(page.locator("#visibilityHiddenButton")).to_be_hidden()
    expect.soft(page.locator("#offscreenButton")).to_be_visible()
    expect.soft(page.locator("#overlappedButton")).to_be_visible()  
    expect.soft(page.locator("#transparentButton")).to_be_visible() 