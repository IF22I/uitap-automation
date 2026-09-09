import os

from playwright.sync_api import sync_playwright


def before_all(context):
    context.base_url = "http://uitestingplayground.com"
    context.playwright = sync_playwright().start()
    is_ci = os.environ.get("CI", "false").lower() == "true"
    context.browser = context.playwright.chromium.launch(headless=is_ci)

def before_scenario(context, scenario):
    context.page = context.browser.new_page()

def after_scenario(context, scenario):
    context.page.close()

def after_all(context):
    context.browser.close()
    context.playwright.stop()