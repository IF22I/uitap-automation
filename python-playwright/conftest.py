    # Launch options shared by every Playwright test.

    # - The timer-throttling flags stop Chrome from delaying page timers in
    #   unfocused tabs, which made the Alerts test flaky (Exercise 18).
    # - The secure-origin flag lets navigator.clipboard work on the plain-HTTP
    #   practice site (Exercise 22).
    # - channel="chromium" uses the full Chromium build instead of the headless
    #   shell, which lacked the clipboard API in CI (Exercise 22).

import pytest


@pytest.fixture(scope="session")
def browser_type_launch_args(browser_type_launch_args, browser_name):
    launch_args = {
        **browser_type_launch_args,
        "args": [
            "--disable-background-timer-throttling",
            "--disable-backgrounding-occluded-windows",
            "--disable-renderer-backgrounding",
            "--disable-features=IntensiveWakeUpThrottling",
            "--unsafely-treat-insecure-origin-as-secure=http://uitestingplayground.com",
        ],
    }
    if browser_name == "chromium":
        launch_args["channel"] = "chromium"
    return launch_args