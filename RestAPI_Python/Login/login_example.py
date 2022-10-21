from urllib import response
import requests
from requests.auth import HTTPBasicAuth

payload = {
            'email': "sean@aqua.com",
            'password': "pw"
        }

response = requests.post('http://localhost:9500/api/arden/user/login', json=payload, auth = HTTPBasicAuth('email','password'))
print('Response Code ' + str(response.status_code))
if response.status_code == 200:
    print('Login succesful: ' + response.text)
