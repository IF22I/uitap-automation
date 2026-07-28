from playwright.sync_api import Page

def login_as(page: Page, username: str, password: str):
    page.goto("http://uitestingplayground.com/sampleapp")
    page.fill("[name='UserName']", username)
    page.fill("[name='Password']", password)
    page.click("#login")