import pytest


@pytest.mark.smoke
@pytest.mark.regression
def test_verify_login_without_email_is_bad_request(api):
    response = api.post_verifyLogin()

    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 400
    assert body["message"] == "Bad request, email or password parameter is missing in POST request."