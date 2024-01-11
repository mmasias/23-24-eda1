package src;

import java.util.Scanner;

public class Day {
    private int day;
    Scanner scanner = new Scanner(System.in);

    public Day(){}

    public static TreeNode getDayNodeOrCreateNew(List<TreeNode> dias, int selectedDay) {
        for (Object day : dias.listData()) {
            TreeNode existingDay = (TreeNode) day;
            if (existingDay.key.equals("Dia " + selectedDay)) {
                return existingDay;
            }
        }

        TreeNode newDay = new TreeNode("Dia " + selectedDay);
        dias.insert(newDay, -1);
        return newDay;
    }

    public void setDay(){
        System.out.println("Seleccione Día");
        int seleccion = scanner.nextInt();
        if (!(seleccion <6 && seleccion > 0)){
            System.out.println("Esa no es una opción, tiene que ser un día de 1 a 5");
            setDay();
        }
        this.day = seleccion;
    }

    public int getDay(){
        return day;
    }
}
