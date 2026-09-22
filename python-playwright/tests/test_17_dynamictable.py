import pytest
from playwright.sync_api import Page, expect

@pytest.mark.smoke
def test_dynamictable(page: Page):

    page.goto("http://uitestingplayground.com/dynamictable")

    headers = page.locator("span[role='columnheader']").all()
    cpu_index = None
    for i, header in enumerate(headers):
        if header.text_content() == "CPU":
            cpu_index = i
            break


    rows = page.locator("div[role='row']").all()
    for row in rows:
        cells = row.locator("span[role='cell']").all()
        if cells and cells[0].text_content() == "Chrome":
            cpu_value = cells[cpu_index].text_content()
            break

    cpu_numeric = float(cpu_value.replace("%", ""))

    warning_text = page.locator("p.bg-warning").text_content()
    label_value_str = warning_text.split(":")[-1].strip()
    label_value = float(label_value_str.replace("%", "")) 

    assert cpu_numeric == label_value