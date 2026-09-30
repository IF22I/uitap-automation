import os
from pathlib import Path

import pytest
from playwright.sync_api import Page, expect


@pytest.mark.smoke
def test_file_upload(page: Page):
    page.goto("http://uitestingplayground.com/upload")

    file_path = Path(__file__).parent / "testdata" / "sample.txt"
    page.frame_locator("iframe").locator("#browse").set_input_files(str(file_path))

    expect(page.frame_locator("iframe").locator(".file-list p")).to_contain_text("sample.txt")

