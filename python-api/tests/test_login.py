import pytest


@pytest.mark.regression
@pytest.mark.parametrize("email, password", [
    (None, None),
    ("test@exmaple.com", None),
    (None, "password")
])
def test_verify_login_without_email_is_bad_request(api, email, password):
    response = api.verify_login(email=email, password=password)

    # This API reports errors in the JSON body, not in the HTTP status
    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 400
    assert body["message"] == "Bad request, email or password parameter is missing in POST request."