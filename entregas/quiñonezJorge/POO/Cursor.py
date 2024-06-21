def printInstructions():
    print("Use W, A, S, D keys to move.", end="\n")
    print("To edit cursor's actual cell press 'E'", end="\n")
    print("To exit the program press 'Q'", end="\n")
    print()


class Cursor:
    def __init__(self, newSheet):
        self.spreadSheet = newSheet
        self.position = [0, 0]

    def moveUp(self):
        if self.position[0] > 0:
            self.position[0] -= 1

    def moveDown(self):
        if self.position[0] < self.spreadSheet.rows - 1:
            self.position[0] += 1

    def moveLeft(self):
        if self.position[1] > 0:
            self.position[1] -= 1

    def moveRight(self):
        if self.position[1] < self.spreadSheet.columns - 1:
            self.position[1] += 1

    def editCurrentCell(self, newValue):
        currentCell = self.spreadSheet.sheet[self.position[0]][self.position[1]]
        currentCell.editValue(newValue)

    def getCurrentCellValue(self):
        currentCell = self.spreadSheet.sheet[self.position[0]][self.position[1]]
        return currentCell.getValue()

    def getCurrentCellPosition(self):
        return self.position

    def handleInput(self):
        userInput = input("Enter a cursor control: ").lower()
        if userInput == "w":
            self.moveUp()
        elif userInput == "s":
            self.moveDown()
        elif userInput == "a":
            self.moveLeft()
        elif userInput == "d":
            self.moveRight()
        elif userInput == "q":
            exit()
        elif userInput == "e":
            newValue = input("Enter a new value for the cell: ")
            self.editCurrentCell(newValue)
