from behave import given, when, then

@given("I am on the sample app page")
def step_open_page(context):
    context.page.goto(f"{context.base_url}/sampleapp")

@when('I log in with username "{username}" and password "{password}"')
def step_login (context, username, password):
    context.page.fill("input[name='UserName']", username)
    context.page.fill("input[name='Password']", password)
    context.page.click("#login")

@then('I should see "{message}"')
def step_verify_message(context, message):
    status = context.page.text_content("#loginstatus")
    assert message in status