# pytest-playwright automatically provides `page`, `browser`, and `context` fixtures.
# Add project-level configuration and custom fixtures here as the course progresses.

import pytest


@pytest.fixture(scope="session")
def browser_type_launch_args(browser_type_launch_args):
    return {
        **browser_type_launch_args,
        "args": [
            "--disable-background-timer-throttling",
            "--disable-backgrounding-occluded-windows",
            "--disable-renderer-backgrounding",
            "--disable-features=IntensiveWakeUpThrottling",
        ],
    }