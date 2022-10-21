from urllib import response
import requests
from requests.auth import HTTPBasicAuth

_baseUrl ="http://172.30.144.1"

def getBaseUrl():
    return _baseUrl

def getArdenUrl():
    return _baseUrl + ":9500/" 

#url = getBaseUrl()
#url = getBaseUrl() + ":9500/"
url = getArdenUrl()
payload = {
            'email': "sean@aqua.com",
            'password': "pw"
        }

response = requests.post("{0}api/arden/user/login".format(url), json=payload, auth = HTTPBasicAuth('email','password'))
print('Response Code ' + str(response.status_code))
if response.status_code == 200:
    print('Login succesful: ' + response.text)
