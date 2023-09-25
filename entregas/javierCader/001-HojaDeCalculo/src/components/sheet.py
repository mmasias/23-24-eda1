from src.components.cell import Cell
from src.utils.console import Console
from src.constants.constants import CELL_WIDTH, DIRECTIONS
from src.constants.colors import HEADER_COLOR, RESET_COLOR

class Sheet:
    def __init__(self, rows, cols):
        self.rows = rows
        self.cols = cols
        self.initialize_sheet()
        
    def get_cols(self):
        return self.sheet[0]
    
    def get_rows(self):
        return self.sheet
        
    def initialize_sheet(self):
        self.sheet = [[Cell() for _ in range(self.cols)] for _ in range(self.rows)]
        
    def set_cell_content(self, row, col, content):
        self.sheet[row][col].content = content
