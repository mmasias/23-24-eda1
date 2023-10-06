package esparragozaVeronika.core;

public class cells {
    private String[][] cell;
    public cells(String[][] cell) {
        this.cell = cell;
    }
    public String getCell(int column, int row){
        return cell[column][row];
    }
    public void setCellValue(int column, int row, String value) {
        this.cell[column][row] = value; // Usar "this" para acceder a la instancia actual y actualizar la celda
    }

}
