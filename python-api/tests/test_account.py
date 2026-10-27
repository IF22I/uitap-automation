import pytest


@pytest.mark.smoke
@pytest.mark.regression
def test_verify_login_with_valid_details(api, account):
    response = api.verify_login(email=account["email"], password=account["password"])

    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 200
    assert body["message"] == "User exists!"


@pytest.mark.regression
def test_create_account_with_existing_email_is_rejected(api, account):
    response = api.create_account(account)

    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 400
    assert body["message"] == "Email already exists!"

@pytest.mark.regression
def test_verify_login_with_wrong_password_is_rejected(api, account):
    response = api.verify_login(email=account["email"], password="skibidi")

    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 404
    assert body["message"] == "User not found!"

@pytest.mark.regression
def test_deleted_account_can_no_longer_log_in(api, account):
    response = api.delete_account(email=account["email"], password=account["password"])

    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 200
    assert body["message"] == "Account deleted!"

    response = api.verify_login(email=account["email"], password=account["password"])

    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 404
    assert body["message"] == "User not found!"