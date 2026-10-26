import pytest


@pytest.mark.smoke
@pytest.mark.regression
def test_get_all_products_returns_list(api):
    response = api.get_products()

    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 200
    assert len(body["products"]) > 0

@pytest.mark.regression
def test_post_to_products_list_is_not_supported(api):
    response = api.post_products()

    # This API reports errors in the JSON body, not in the HTTP status
    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 405
    assert body["message"] == "This request method is not supported."