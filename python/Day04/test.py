import os

target = input("�������� ���丮:")

dir = target
kids = os.listdir(dir)
for kid in kids:
    if os.path.isfile(dir+ "\\" + kid):
        print("[F] ", kid)
    else:
        print("[D] ", kid)
