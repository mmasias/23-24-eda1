package esparragozaVeronika.view;

public class excelStructure {
    static String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    public void initialDataInTable(String[][] table){
        for (int column = 0; column < table.length; column++) {
            for (int row = 0; row < table[0].length; row++){
                table[column][row] = " ".repeat(7);
            }
        }
    }
    public void printTableHeader(){
        System.out.print("__");
        for (int letter = 0; letter < alphabet.length; letter++){
            System.out.print("|__ " + alphabet[letter] + " __|");
        }
    }
    private static void printNumberOfRows(int column){
        System.out.println("");
        if(column < 10){
            System.out.print("0" + column);
        } else {
            System.out.print(column);
        };
    }
    public void printTableBody(String[][] table, int[] userPosition){
        for (int column = 1; column < table.length; column++) {
            printNumberOfRows(column);
            for (int row = 0; row < table[0].length; row++) {
                if (userPosition[0] == row && userPosition[1] == column) {
                    System.out.print("\u001B[31m[" + table[column][row] +"]\u001B[0m");
                } else{
                    System.out.print("|" + table[column][row] + "|");
                }
            }
        }
        System.out.println("");
    }

    public boolean programsEnds(String inputUser){
        if (inputUser.equals(":q")){
            return true;
        } else {
            return false;
        }
    }
}
