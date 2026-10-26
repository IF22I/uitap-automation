import requests
from config import BASE_URL


class AutomationExerciseClient:
    def __init__(self, base_url=BASE_URL, timeout=10):
        self.base_url = base_url
        self.timeout = timeout
        self.session = requests.Session()

    def _url(self, path):
        return f"{self.base_url}/{path}"

    def get_products(self):
        return self.session.get(self._url("productsList"), timeout=self.timeout)

    def post_products(self):
        return self.session.post(self._url("productsList"), timeout=self.timeout)

    def search_products(self, term=None):
        data = {"search_product": term} if term is not None else None
        return self.session.post(self._url("searchProduct"), data=data, timeout=self.timeout)

    def close(self):
        self.session.close()