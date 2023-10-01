package Utils;

class Movement {
    public int getCurrentRow(String currentCell) {
        return Integer.parseInt(currentCell.substring(1)) - 1;
    }

    public int getCurrentColumn(String currentCell) {
        return currentCell.charAt(0) - 'A';
    }

    public String handleCommand(String command, String currentCell) {
        switch (command) {
            case "w":
                return moveUp(currentCell);
            case "a":
                return moveLeft(currentCell);
            case "s":
                return moveDown(currentCell);
            case "d":
                return moveRight(currentCell);
            default:
                System.out.println("Comando no reconocido.");
                return currentCell;
        }
    }

    private String moveUp(String currentCell) {
        int row = getCurrentRow(currentCell);
        return row > 0 ? String.format("%c%d", currentCell.charAt(0), row) : currentCell;
    }

    private String moveDown(String currentCell) {
        int row = getCurrentRow(currentCell);
        return row < 14 ? String.format("%c%d", currentCell.charAt(0), row + 2) : currentCell;
    }

    private String moveLeft(String currentCell) {
        char column = currentCell.charAt(0);
        return column > 'A' ? String.format("%c%d", (char) (column - 1), getCurrentRow(currentCell) + 1) : currentCell;
    }

    private String moveRight(String currentCell) {
        char column = currentCell.charAt(0);
        return column < 'J' ? String.format("%c%d", (char) (column + 1), getCurrentRow(currentCell) + 1) : currentCell;
    }
}