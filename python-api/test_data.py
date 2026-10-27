import uuid

def new_account():
    unique = uuid.uuid4().hex[:8]
    return {
        "name": f"Test User {unique}",
        "email": f"uitap.test.{unique}@example.com",
        "password": f"Pw-{unique}",
        "title": "Mr",
        "birth_date": "15",
        "birth_month": "6",
        "birth_year": "1990",
        "firstname": "Test",
        "lastname": "User",
        "company": "Test Company",
        "address1": "Teststrasse 1",
        "address2": "",
        "country": "India",
        "zipcode": "8000",
        "state": "Zurich",
        "city": "Zurich",
        "mobile_number": "0790000000",
    }