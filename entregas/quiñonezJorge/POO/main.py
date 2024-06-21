from SpreadSheet import SpreadSheet
from Cursor import Cursor
from Cursor import printInstructions


class Main:
    rows = 15
    columns = 10
    sheet = SpreadSheet(rows, columns)
    cursor = Cursor(sheet)

    while True:
        printInstructions()
        cursor.handleInput()
        currentPosition = cursor.getCurrentCellPosition()
        sheet.printColumnIndexes()
        sheet.printBorders()
        sheet.printSheet(cursor)
