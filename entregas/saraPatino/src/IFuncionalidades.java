package src;

public interface IFuncionalidades {

    public void startingExcel(String[][] excel);

    public void printHeaders();

    public void printOptions(int[] position);

    public void printing(String[][] excel, int[] position);

    public boolean processCommand(char command, String[][] excel, int[] position);

    public void clean();

}