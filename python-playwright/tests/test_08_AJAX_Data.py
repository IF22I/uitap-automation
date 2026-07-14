def test_ajax_data(page):
    page.goto("http://uitestingplayground.com/ajax")
    page.click("#ajaxButton")
    page.click("text=Data loaded with AJAX get request.", timeout=20000) #default is 30000 which is enough for the exercise