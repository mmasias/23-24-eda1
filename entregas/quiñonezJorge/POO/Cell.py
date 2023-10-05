class Cell:
    def __init__(self, row, column):
        self.position = [row, column]
        self.cellValue = ''

    def editValue(self, newValue):
        self.cellValue = newValue

    def getValue(self):
        return self.cellValue

