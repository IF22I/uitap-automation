from playwright.sync_api import Page

class BasePage:

    def __init__(self, page: Page):
        self.page = page

    def go_to(self, url: str):
        self.page.goto(url)

    