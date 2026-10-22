import pytest
import requests

from config import BASE_URL


@pytest.mark.smoke
@pytest.mark.regression
def test_get_all_products_returns_list():
    response = requests.get(f"{BASE_URL}/productsList", timeout=10)

    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 200
    assert len(body["products"]) > 0

@pytest.mark.regression
def test_post_to_products_list_is_not_supported():
    response = requests.post(f"{BASE_URL}/productsList", timeout=10)

    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 405
    assert body["message"] == "This request method is not supported."