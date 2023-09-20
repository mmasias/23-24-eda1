class App:

    MOVEMENT_ACTIONS = ["w", "a", "s", "d", "e", "q"]

    spreadsheet = [["      " for _ in range(10)] for _ in range(15)]
    currentRow = 0
    currentColumn = 0

    @staticmethod
    def main():
        isRunning = True

        App.initializeSpreadsheet()
        while isRunning:
            App.displaySpreadsheet()

            print(f"Current cell -> [{App.convertColumnToLetter(App.currentColumn)}{App.currentRow}]")
            print("Use the W, A, S & D keys to move around the spreadsheet.")
            print("Press 'E' to enter a text in the current cell.")
            print("Press 'Q' to exit.")

            userInput = input()

            if userInput == "w":
                App.moveUp()
            elif userInput == "a":
                App.moveLeft()
            elif userInput == "s":
                App.moveDown()
            elif userInput == "d":
                App.moveRight()
            elif userInput == "e":
                App.enterText()
            elif userInput == "q":
                isRunning = False
            else:
                print("Invalid input. Please try again.")

    @staticmethod
    def initializeSpreadsheet():
        for i in range(len(App.spreadsheet)):
            for j in range(len(App.spreadsheet[0])):
                App.spreadsheet[i][j] = "       "

    @staticmethod
    def displaySpreadsheet():
        print("    ", end="")
        for col in range(len(App.spreadsheet[0])):
            print(f"{App.convertColumnToLetter(col):^7}", end=" ")
        print("\n   +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+")

        for i in range(len(App.spreadsheet)):
            print(f"{i + 1:2d}", end=" ")
            for j in range(len(App.spreadsheet[i])):
                if i == App.currentRow and j == App.currentColumn:
                    print("|[_____]", end="")
                else:
                    print(f"|{App.spreadsheet[i][j]}", end="")
            print("|")

        print("   +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+")

    @staticmethod
    def moveUp():
        if App.currentRow > 0:
            App.currentRow -= 1

    @staticmethod
    def moveDown():
        if App.currentRow < len(App.spreadsheet) - 1:
            App.currentRow += 1

    @staticmethod
    def moveLeft():
        if App.currentColumn > 1:
            App.currentColumn -= 1

    @staticmethod
    def moveRight():
        if App.currentColumn < len(App.spreadsheet[0]) - 1:
            App.currentColumn += 1

    @staticmethod
    def enterText():
        print("Enter the text for the cell:")
        text = input()

        if len(text) > 7:
            App.spreadsheet[App.currentRow][App.currentColumn] = text[:7]
        else:
            spaces = 7 - len(text)
            text = " " * spaces + text
            App.spreadsheet[App.currentRow][App.currentColumn] = text

    @staticmethod
    def convertColumnToLetter(column):
        letter = chr(ord('A') + column)
        return str(letter)


if __name__ == "__main__":
    App.main()
