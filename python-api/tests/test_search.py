import pytest


@pytest.mark.smoke
@pytest.mark.regression
@pytest.mark.parametrize("term", ["top", "jean", "dress"])
def test_search_product_returns_results(api, term):
    response = api.search_products(term)

    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 200
    assert len(body["products"]) > 0

    for product in body["products"]:
        searchable = f'{product["name"]} {product["category"]["category"]}'.lower()
        assert term in searchable, f"'{term}' not found in: {searchable}"

@pytest.mark.regression
def test_search_product_without_parameter_is_bad_request(api):
    response = api.search_products()

    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 400
    assert body["message"] == "Bad request, search_product parameter is missing in POST request."

@pytest.mark.regression
def test_search_product_with_no_match_returns_empty_list(api):
    response = api.search_products("xyz123")

    assert response.status_code == 200
    body = response.json()
    assert body["responseCode"] == 200
    assert len(body["products"]) == 0