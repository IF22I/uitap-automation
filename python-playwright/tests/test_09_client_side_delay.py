def test_client_side_delay(page):
   page.goto("http://uitestingplayground.com/clientdelay")
   page.click("#ajaxButton")
   page.click("text=Data calculated on the client side.")