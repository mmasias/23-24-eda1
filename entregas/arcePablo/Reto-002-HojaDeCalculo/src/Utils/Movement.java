package Utils;

class Movement {
    private static String currentCell;

    public Movement(String initialCell) {
        currentCell = initialCell;
    }

    static public String getCurrentCell() {
        return currentCell;
    }

    public int getCurrentRow() {
        return Integer.parseInt(currentCell.substring(1)) - 1;
    }

    public int getCurrentColumn() {
        return currentCell.charAt(0) - 'A';
    }

    public void handleCommand(String command) {
        switch (command) {
            case "w":
                currentCell = moveUp();
                break;
            case "a":
                currentCell = moveLeft();
                break;
            case "s":
                currentCell = moveDown();
                break;
            case "d":
                currentCell = moveRight();
                break;
            default:
                System.out.println("Comando no reconocido.");
        }
    }

    private String moveUp() {
        int row = getCurrentRow();
        return row > 0 ? String.format("%c%d", currentCell.charAt(0), row) : currentCell;
    }

    private String moveDown() {
        int row = getCurrentRow();
        return row < 17 ? String.format("%c%d", currentCell.charAt(0), row + 2) : currentCell;
    }

    private String moveLeft() {
        char column = currentCell.charAt(0);
        return column > 'A' ? String.format("%c%d", (char) (column - 1), getCurrentRow() + 1) : currentCell;
    }

    private String moveRight() {
        char column = currentCell.charAt(0);
        return column < 'J' ? String.format("%c%d", (char) (column + 1), getCurrentRow() + 1) : currentCell;
    }
}