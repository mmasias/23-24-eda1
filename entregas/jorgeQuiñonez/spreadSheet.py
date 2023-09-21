
sheet = [["" for x in range(10)] for y in range(15)]
cursor = [0, 0]
cellLength = 7
leftSpacing = 5
columnNames = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"]
rowNames = ["1", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "11", "12", "13", "14", "15"]


def run():

    printColumnIndex()
    printBorders()
    printSheet()
    showInstructions()

    while cursorControl():
        printColumnIndex()
        printBorders()
        printSheet()
        showInstructions()


def showInstructions():
    print("Use W, A, S, D keys to move.", end="\n")
    print("To edit cursor's actual cell press 'E'", end="\n")
    print("To exit the program press 'Q'", end="\n")
    print()


def cursorControl():
    userInput = input("Ingrese un control del cursor: ").lower()
    print()
    if userInput == "w":
        cursor[0] -= 1
        if (cursor[0] < 0):
            cursor[0] += 1
    elif userInput == "s":
        cursor[0] += 1
        if (cursor[0] > 14):
            cursor[0] -= 1
    elif userInput == "a":
        cursor[1] -= 1
        if (cursor[1] < 0):
            cursor[1] += 1
    elif userInput == "d":
        cursor[1] += 1
        if (cursor[1] > 9):
            cursor[1] -= 1
    elif userInput == "q":
        return False
    elif userInput == "e":
        editCell(cursor[0], cursor[1])
    return True


def printColumnIndex():
    print(" " * cellLength, end="")
    for i in range(1):
        for j in range(10):
            print(columnNames[j] + " " * cellLength, end="")
        print()


def printBorders():
    print(" " * leftSpacing, end="")
    for i in range(10):
        print("+-------", end="")
    print("+")


def printSheet():
    for i in range(len(rowNames)):
        if (len(rowNames[i]) < 2):
            print(rowNames[i] + " " * (leftSpacing - 1), end="")
        else:
            print(rowNames[i] + " " * (leftSpacing - 2), end="")
        for j in range(len(columnNames)):
            value = sheet[i][j]
            if (value):
                if (len(value) > cellLength):
                    value = value[:cellLength]
                    print("|" + str(value), end="")
                elif (len(value) <= cellLength):
                    print("|" + str(value) + " " *
                          (cellLength - len(value)), end="")
            elif i == cursor[0] and j == cursor[1]:
                print("|" + "[" + " "*(cellLength - 2) + "]", end="")
            else:
                print("|" + " " * cellLength, end="")
        print("|")
    printBorders()
    printActualCell(cursor[0], cursor[1])


def editCell(column, row):
    insertedText = input("Escriba para editar el contenido de la celda: ")
    sheet[column][row] = str(insertedText)
    print()


def printActualCell(row, column):
    print("Celda actual =>  [" + columnNames[column] + rowNames[row] + "]")


run()
