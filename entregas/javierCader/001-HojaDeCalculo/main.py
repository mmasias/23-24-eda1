from src.app import MainApp
from src.constants.constants import ROWS, COLS

if __name__ == "__main__":
    app = MainApp(ROWS, COLS)
    app.run()
