# pytest-playwright automatically provides `page`, `browser`, and `context` fixtures.
# Add project-level configuration and custom fixtures here as the course progresses.

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