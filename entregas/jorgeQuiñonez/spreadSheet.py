import numpy as np

sheet = np.zeros((10, 15), dtype=int)
cursor = [0, 0]
columnNames = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"]
rowNames = ["01", "02", "03", "04", "05", "06", "07",
            "08", "09", "10", "11", "12", "13", "14", "15"]


def run():
    printBorders()
    printSheet()
    while cursorControl():
        printBorders()
        printSheet()


def cursorControl():
    userInput = input()
    if userInput == "w":
        cursor[0] -= 1
    elif userInput == "s":
        cursor[0] += 1
    elif userInput == "a":
        cursor[1] -= 1
    elif userInput == "d":
        cursor[1] += 1
    elif userInput == "q":
        return False
    return True


def printBorders():
    print("       ", end="")
    for i in range(1):
        for j in range(10):
            print(columnNames[j] + "      ", end="")
        print()
    print("     ", end="")
    for i in range(10):
        print("+-------", end="")
    print("+")


def printSheet():
    columns = [""] * 15
    rows = [""] * 10
    for i in range(15):
        print(rowNames[i] + "   ", end="")
        for j in range(10):
            if i == cursor[0] and j == cursor[1]:
                print("|[     ]", end="")
            else:
                print("|       ", end="")
        print("|")
    printBorders()


run()
