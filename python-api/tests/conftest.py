import pytest
from api_client import AutomationExerciseClient
from test_data import new_account


@pytest.fixture(scope="session")
def api():
    client = AutomationExerciseClient()
    yield client
    client.close()

@pytest.fixture
def account(api):
    data = new_account()
    response = api.create_account(data)
    assert response.json()["responseCode"] == 201, f"Could not create test account: {response.text}"

    yield data

    api.delete_account(data["email"], data["password"])