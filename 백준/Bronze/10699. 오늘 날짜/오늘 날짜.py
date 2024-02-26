import datetime

datetime_utc = datetime.datetime.now(datetime.UTC)
datetime_kor = datetime_utc + datetime.timedelta(hours=9)

year = datetime_kor.year
month = datetime_kor.month
day = datetime_kor.day

print("{:04d}-{:02d}-{:02d}".format(year, month, day))