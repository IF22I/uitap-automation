from pages.base_page import BasePage
from playwright.sync_api import Page
from config import BASE_URL

class LoginPage(BasePage):

    def __init__(self, page: Page):
        super().__init__(page)

        self.username_field = "[name='UserName']"
        self.password_field = "[name='Password']"
        self.login_button = "#login"
        self.status_message = "#loginstatus"

    def login(self, username: str, password: str):
        self.go_to(f"{BASE_URL}/sampleapp")
        self.page.fill(self.username_field, username)
        self.page.fill(self.password_field, password)
        self.page.click(self.login_button)

    def get_status(self) -> str:
        return self.page.locator(self.status_message).inner_text()