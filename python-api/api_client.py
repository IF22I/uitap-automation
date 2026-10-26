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

    def get_brandsList(self):
        return self.session.get(self._url("brandsList"), timeout=self.timeout)

    def put_brandsList(self):
        return self.session.put(self._url("brandsList"), timeout=self.timeout)

    def post_verifyLogin(self, email = None, password = None):
        data = {}
        if email is not None:
            data["email"] = email
        if password is not None:
            data["password"] = password
        return self.session.post(self._url("verifyLogin"), data=data or None, timeout=self.timeout)

    def close(self):
        self.session.close()