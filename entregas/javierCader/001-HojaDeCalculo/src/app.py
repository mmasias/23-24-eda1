import os

CELL_WIDTH = 7 
DIRECTIONS = {
    'w': (-1, 0),
    's': (1, 0),
    'a': (0, -1),
    'd': (0, 1)
}
SUCCESS_COLOR = '\033[92m'  
ERROR_COLOR = '\033[91m'    
RESET_COLOR = '\033[0m'     
ACTIVE_BG_COLOR = '\033[100m' 
ACTIVE_FG_COLOR = '\033[97m'  
HEADER_COLOR = '\033[94m'   

def clear_console():
    os.system('cls' if os.name == 'nt' else 'clear') 

def get_user_input():
    print(f"{SUCCESS_COLOR}Instructions:{RESET_COLOR}")
    return input("Move with (w/a/s/d), Edit with 'e', Quit with 'q': ").lower()

def print_separator(cols):
    print("┌" + "┬".join(["─" * CELL_WIDTH for _ in range(cols)]) + "┐")

def print_headers(cols):
    headers = [HEADER_COLOR + chr(65 + col).center(CELL_WIDTH) + RESET_COLOR for col in range(cols)]
    print("│" + "│".join(headers) + "│")

def print_row_separator(cols):
    print("├" + "┼".join(["─" * CELL_WIDTH for _ in range(cols)]) + "┤")

def print_footer(cols):
    print("└" + "┴".join(["─" * CELL_WIDTH for _ in range(cols)]) + "┘")
    print()

def print_sheet(sheet, current_pos):
    clear_console() 
    print(HEADER_COLOR + "Python Excel App v1.0 By Javier Cáder".center(CELL_WIDTH * len(sheet[0]) + 11) + RESET_COLOR)
    print_separator(len(sheet[0]))
    print_headers(len(sheet[0]))
    print_row_separator(len(sheet[0]))

    for i, row in enumerate(sheet):
        print_row(row, i, current_pos)
        if i != len(sheet) - 1:
            print_row_separator(len(sheet[0]))
    print_footer(len(sheet[0]))

def print_row(row, row_idx, current_pos):
    row_data = []
    for j, cell in enumerate(row):
        cell_content = format_cell_content(cell, (row_idx, j) == current_pos)  # Use row_idx and j to identify the current cell
        row_data.append(cell_content)
    print("│" + "│".join(row_data) + "│")

def format_cell_content(content, is_active):
    if is_active:
        return ACTIVE_BG_COLOR + ACTIVE_FG_COLOR + content.center(CELL_WIDTH) + RESET_COLOR
    return content.center(CELL_WIDTH)

def move(direction, current_pos, max_rows, max_cols):
    dx, dy = DIRECTIONS.get(direction, (0, 0))
    x, y = current_pos
    x = max(0, min(x + dx, max_rows - 1))
    y = max(0, min(y + dy, max_cols - 1))
    return x, y

def edit_cell(sheet, current_pos):
    content = input("Enter cell content: ")[:CELL_WIDTH]
    sheet[current_pos[0]][current_pos[1]] = content

def main():
    rows, cols = 15, 10
    sheet = [[" " * CELL_WIDTH for _ in range(cols)] for _ in range(rows)]
    current_pos = (0, 0)

    running = True 
    while running:
        print_sheet(sheet, current_pos)
        action = get_user_input()

        if action == "q":
            running = False 
        elif action == "e":
            edit_cell(sheet, current_pos)
        else:
            current_pos = move(action, current_pos, rows, cols)

if __name__ == "__main__":
    main()
