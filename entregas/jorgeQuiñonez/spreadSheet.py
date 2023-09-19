
global columns
global rows


def insertText():
    text = input().toString()
    return text


def printSheet():
    columns = [""] * 15
    rows = [""] * 10

    for i in rows:
        for j in columns:
            print("       ", end="|")
        print()


printSheet()
