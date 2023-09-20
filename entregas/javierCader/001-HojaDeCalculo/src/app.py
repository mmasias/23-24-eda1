import os, sys, time, requests, json, shutil

CELL_WIDTH = 7 

DIRECTIONS = {
    'w': (-1, 0),
    's': (1, 0),
    'a': (0, -1),
    'd': (0, 1)
}

API_ENDPOINT = "https://us-central1-excel-converter-745fc.cloudfunctions.net/api"

SUCCESS_COLOR = '\033[92m'  
ERROR_COLOR = '\033[91m'    
RESET_COLOR = '\033[0m'     
HIGHLIGHT_START = '\033[47m' 
HIGHLIGHT_END = '\033[m'
ACTIVE_BG_COLOR = '\033[100m' 
ACTIVE_FG_COLOR = '\033[97m'  
HEADER_COLOR = '\033[94m'   


def clear_console():
    os.system('cls' if os.name == 'nt' else 'clear') 
       
def print_and_take_instructions():
    print(f"{SUCCESS_COLOR}Instructions:{RESET_COLOR}")
    return input("Move with (w/a/s/d), Edit with 'e', Export with 'export', Import with 'import', Quit with 'q': ").lower()

def print_separator(sheet):
    print("┌" + "┬".join(["─" * CELL_WIDTH for _ in sheet[0]]) + "┐")

def print_headers(sheet):
    headers = [HEADER_COLOR + chr(65 + col).center(CELL_WIDTH) + RESET_COLOR for col in range(len(sheet[0]))]
    print("│" + "│".join(headers) + "│")

def print_row_separator(sheet):
    print("├" + "┼".join(["─" * CELL_WIDTH for _ in sheet[0]]) + "┤")

def print_footer(sheet):
    print("└" + "┴".join(["─" * CELL_WIDTH for _ in sheet[0]]) + "┘")
    print()  # Newline

def print_sheet(sheet, current_pos, active_color=ACTIVE_FG_COLOR):
    clear_console() 
    print(HEADER_COLOR + "Python Excel App v1.0 By Javier Cáder".center(CELL_WIDTH * 10 + 11) + RESET_COLOR)
    print_separator(sheet)
    print_headers(sheet)
    print_row_separator(sheet)

    for i, row in enumerate(sheet):
        row_data = []
        for j, cell in enumerate(row):
            cell_content = cell.center(CELL_WIDTH)
            if (i, j) == current_pos:
                cell_content = ACTIVE_BG_COLOR + active_color + cell_content + RESET_COLOR  # Change only cell color, not the entire row
            row_data.append(cell_content)
        print("│" + "│".join(row_data) + "│")
        if i != len(sheet) - 1:
            print_row_separator(sheet)
    print_footer(sheet)

def move(direction, current_pos, max_rows, max_cols):
    dx, dy = DIRECTIONS.get(direction, (0, 0))
    x, y = current_pos
    x = max(0, min(x + dx, max_rows - 1))
    y = max(0, min(y + dy, max_cols - 1))
    return x, y

def edit_cell(sheet, current_pos):
    content = input("Enter cell content: ")[:CELL_WIDTH]
    sheet[current_pos[0]][current_pos[1]] = content

def loading_animation():
    animation_chars = ['|', '/', '-', '\\']
    for char in animation_chars:
        sys.stdout.write('\r' + 'Waiting for API response... ' + char)
        sys.stdout.flush()
        time.sleep(0.2)

def export_to_api(sheet):
    data = {"data": sheet}
    headers = {'Content-Type': 'application/json'}
    filename = input("Enter the desired name for the Excel file (without extension): ").strip()
    if not filename: 
        filename = "converted"
    data["filename"] = filename 

    for _ in range(10):
        loading_animation()

    response = requests.post(API_ENDPOINT + "/csvtoexcel", data=json.dumps(data), headers=headers)
    
    if response.status_code == 200:
        download_link = response.json().get('url')
        print(f"\n{SUCCESS_COLOR}Excel file created! Download from: {download_link}{RESET_COLOR}")
        input("Press Enter to continue...")
    else:
        print(f"\n{ERROR_COLOR}Error exporting to Excel. Please try again.{RESET_COLOR}")
        print(f"Status Code: {response.status_code}")
        print(f"Error Message: {response.text}")

        
def list_excel_files():
    response = requests.get(API_ENDPOINT + "/listexcel")
    return response.json().get("fileNames", [])

def import_from_api():
    files = list_excel_files()
    for idx, filename in enumerate(files):
        print(f"{idx + 1}. {filename}")

    choice = int(input("Select a file number to import: "))
    if 0 < choice <= len(files):
        selected_file = files[choice - 1]
        response = requests.get(API_ENDPOINT + f"/exceltoarray/{selected_file}")
        data = response.json().get("data", [])

        data = [list(map(str, row)) for row in data]

        return data

    print(f"{ERROR_COLOR}Invalid choice!{RESET_COLOR}")
    return []

def main():
    rows, cols = 15, 10
    sheet = [[" " * CELL_WIDTH for _ in range(cols)] for _ in range(rows)]
    current_pos = (0, 0)

    while True:
        print_sheet(sheet, current_pos)
        action = print_and_take_instructions()

        if action == "q":
            break
        elif action == "e":
            edit_cell(sheet, current_pos)
        elif action == "export":
            export_to_api(sheet)
        elif action == "import":
            sheet = import_from_api()
            rows, cols = len(sheet), len(sheet[0]) if sheet else (15, 10)
            sheet = sheet or [[" " * CELL_WIDTH for _ in range(cols)] for _ in range(rows)]
        else:
            current_pos = move(action, current_pos, rows, cols)

if __name__ == "__main__":
    main()
