from datetime import datetime
from time import sleep
import requests

def get_feiertage(year):
    bundesland = "BW" #Baden-Württemberg
    api_url = f"https://feiertage-api.de/api/?jahr={year}&nur_land={bundesland}"

    try:
        response = requests.get(api_url)
        if response.status_code == 200:
            data = response.json()
            return data
        else:
            print(f"Error: Unable to fetch holidays. Status code: {response.status_code}")
    except requests.RequestException as e:
        print(f"Error: {e}")



today = datetime.today()
year = today.year
feiertage = get_feiertage(year)
today_formatted = today.strftime('%Y-%m-%d')
upcoming_holidays = [name for name, details in feiertage.items() if details['datum'] > today_formatted]
len_holidays = len(upcoming_holidays)


print(f"Es sind {len_holidays} Feiertage in diesem Jahr übrig.")
if len_holidays >= 3:
    print("Die nächsten 3 Feiertage sind:\n")
elif len_holidays < 3 and len_holidays > 0:
    print(f"Die nächsten {len_holidays} Feiertage sind:\n")
else:
    print("Es sind keine Feiertage mehr übrig in diesem Kalenderjahr.")

for i, holiday in enumerate(upcoming_holidays):
    if i >= 3:
        break
    feiertag = datetime.strptime(feiertage[holiday]['datum'], '%Y-%m-%d').date()
    wochentag = feiertag.strftime('%A')
    print(f"{holiday} am {feiertag} ({wochentag})")

sleep(10)