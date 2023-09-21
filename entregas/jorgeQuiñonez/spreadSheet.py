
sheet = [["" for x in range(10)] for y in range(15)]
cursor = [0, 0]
cellLenght = 7
columnNames = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"]
rowNames = ["01", "02", "03", "04", "05", "06", "07",
            "08", "09", "10", "11", "12", "13", "14", "15"]


def run():
    showInstructions()

    printColumnIndex()
    printBorders()
    printSheet()

    while cursorControl():
        printColumnIndex()
        printBorders()
        printSheet()


def showInstructions():
    print("---------------------------------------------INSTRUCTIONS---------------------------------------------")
    print("The program works with lower or capital letters")
    print("To move the cursor in the cheatsheet use: W, A, S, D keys", end="\n")
    print("To edit cursor's actual cell press E", end="\n")
    print("To exit the program press Q", end="\n")
    print()


def cursorControl():
    userInput = input("Ingrese una tecla: ").lower()
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
    print("       ", end="")
    for i in range(1):
        for j in range(10):
            print(columnNames[j] + "       ", end="")
        print()


def printBorders():
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
            value = sheet[i][j]
            if (value):
                if (len(value) > cellLenght - 2):
                    value = value[:cellLenght]
                print("|" + str(value), end="")
            elif i == cursor[0] and j == cursor[1]:
                print("|" + "[" + " "*(cellLenght - 2) + "]", end="")
            else:
                print("|" + " " * cellLenght, end="")
        print("|")
    printBorders()
    print("Cursor position: " + str(cursor))


def editCell(x, y):
    insertedText = input("Escriba para editar el contenido de la celda: ")
    sheet[x][y] = str(insertedText)


run()
