from src.utils.console import Console
from src.constants.constants import CELL_WIDTH

class CellContentEditor:
    def __init__(self, sheet):
        self.sheet = sheet

    def edit(self, row, col):
        content = Console.get_cell_content_input()
        validated_content = self._validate_content(content)
        self.sheet.set_cell_content(row, col, validated_content)

    def _validate_content(self, content):
        if len(content) > CELL_WIDTH:
            print("Content is too long. Truncating...")
            return content[:CELL_WIDTH]
        return content
