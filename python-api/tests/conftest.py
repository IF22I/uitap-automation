import pytest
from api_client import AutomationExerciseClient


@pytest.fixture(scope="session")
def api():
    client = AutomationExerciseClient()
    yield client
    client.close()

