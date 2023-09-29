package classes;

public class Spreadsheet {

  private String[][] cells;
  private int currentRow;
  private int currentColumn;

  public Spreadsheet(int rows, int columns) {
    cells = new String[rows][columns];
    initializeSpreadsheet();
  }

  private void initializeSpreadsheet() {
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[0].length; j++) {
        cells[i][j] = "      ";
      }
    }
  }

  public void display() {
    System.out.print("  ");
    for (int col = 0; col < cells[0].length; col++) {
      System.out.printf("%7s ", convertColumnToLetter(col));
    }
    System.out.println("");
    System.out.println("   +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");

    for (int i = 0; i < cells.length; i++) {
      System.out.printf("%2d ", (i + 1));
      for (int j = 0; j < cells[i].length; j++) {
        if (i == currentRow && j == currentColumn) {
          System.out.print("|[_____]");
        } else {
          System.out.printf("|%7s", cells[i][j]);
        }
      }
      System.out.println("|");
    }

    System.out.println("   +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
  }

  public void moveUp() {
    if (currentRow > 0) {
      currentRow--;
    }
  }

  public void moveDown() {
    if (currentRow < cells.length - 1) {
      currentRow++;
    }
  }

  public void moveLeft() {
    if (currentColumn > 1) {
      currentColumn--;
    }
  }

  public void moveRight() {
    if (currentColumn < cells[0].length - 1) {
      currentColumn++;
    }
  }

  public void enterText(String text) {
    if (text.length() > 7) {
      cells[currentRow][currentColumn] = text.substring(0, 7);
    } else if (text.length() < 7) {
      int spaces = 7 - text.length();
      text = " ".repeat(spaces) + text;
      cells[currentRow][currentColumn] = text;
    } else {
      cells[currentRow][currentColumn] = text;
    }
  }

  public int getCurrentRow() {
    return currentRow;
  }

  public String getCurrentColumnLetter() {
    char letter = (char) ('A' + currentColumn);
    return String.valueOf(letter);
  }

  private String convertColumnToLetter(int column) {
    char letter = (char) ('A' + column);
    return String.valueOf(letter);
  }
}
