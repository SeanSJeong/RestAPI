import requests
import json
from pip._vendor.requests.models import Response

# https://www.youtube.com/watch?v=qbLc5a9jdXo
# 27:53

# https://api.stackexchange.com/docs
# https://api.stackexchange.com/docs/questions
# https://api.stackexchange.com/2.3/questions?order=desc&sort=activity&site=stackoverflow


response = requests.get('https://api.stackexchange.com/2.3/questions?order=desc&sort=activity&site=stackoverflow')

# print(response.json())
for data in response.json()['items']:
    if data['answer_count'] == 0:
        print(data['title'])
        print(data['link'])
        print()
    else:
        print("skipped")
    print()