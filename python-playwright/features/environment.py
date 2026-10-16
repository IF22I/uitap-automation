import os

from playwright.sync_api import sync_playwright

from config import BASE_URL

SUPPORTED_BROWSERS = ("chromium", "firefox", "webkit")


def before_all(context):
    context.base_url = BASE_URL
    browser_name = context.config.userdata.get("browser", "chromium")
    if browser_name not in SUPPORTED_BROWSERS:
        raise ValueError(f"Unsupported browser: {browser_name}")

    is_ci = os.environ.get("CI", "false").lower() == "true"
    context.playwright = sync_playwright().start()
    browser_type = getattr(context.playwright, browser_name)
    context.browser = browser_type.launch(headless=is_ci)


def before_scenario(context, scenario):
    context.page = context.browser.new_page()


def after_scenario(context, scenario):
    context.page.close()


def after_all(context):
    browser = getattr(context, "browser", None)
    if browser:
        browser.close()

    playwright = getattr(context, "playwright", None)
    if playwright:
        playwright.stop()