from Cell import Cell


class SpreadSheet:
    def __init__(self, rows, columns):
        self.rows = rows
        self.columns = columns
        self.sheet = [[Cell(row, col) for col in range(columns)] for row in range(rows)]
        self.columnNames = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"]
        self.rowNames = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"]
        self.cellLength = 7
        self.leftSpacing = 5

    def printColumnIndexes(self):
        print(' ' * self.cellLength, end='')
        for i in range(1):
            for j in range(10):
                print(self.columnNames[j] + " " * self.cellLength, end="")
            print()

    def printBorders(self):
        print(" " * self.leftSpacing, end="")
        for i in range(10):
            print("+-------", end="")
        print("+")

    def printActualCell(self, row, column):
        print("Celda actual =>  [" + self.columnNames[column] + self.rowNames[row] + "]")

    def printSheet(self, cursor):
        for i in range(len(self.rowNames)):
            if len(self.rowNames[i]) < 2:
                print(self.rowNames[i] + " " * (self.leftSpacing - 1), end="")
            else:
                print(self.rowNames[i] + " " * (self.leftSpacing - 2), end="")
            for j in range(len(self.columnNames)):
                value = self.sheet[i][j].getValue()
                if value:
                    self.printValues(value)
                elif i == cursor.getCurrentCellPosition()[0] and j == cursor.getCurrentCellPosition()[1]:
                    print("|" + "[" + " " * (self.cellLength - 2) + "]", end="")
                else:
                    print("|" + " " * self.cellLength, end="")
            print("|")
        self.printBorders()
        self.printActualCell(cursor.getCurrentCellPosition()[0], cursor.getCurrentCellPosition()[1])

    def printValues(self, value):
        if len(value) > self.cellLength:
            value = value[:self.cellLength]
            print("|" + str(value), end="")
        elif len(value) <= self.cellLength:
            print("|" + str(value) + " " * (self.cellLength - len(value)), end="")

