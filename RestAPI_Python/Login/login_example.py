import requests
import json

def login(mail, password):
    s = requests.Session()
    payload = {
            'email': mail,
            'password': password
        }
    res = s.post('http://localhost:9500/api/arden/user/login', json=payload)
    #json = payload     data = json.dumps(payload)
    #s.headers.update({'authorization': json.loads(res.content)['token']})

    print(res.content)
    return s
session = login('sean@aqua.com', 'pw')
print(session)
