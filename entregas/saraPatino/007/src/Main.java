package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu nombre");
        String name = scanner.nextLine();
        TreeNode paciente = new TreeNode(name);

        List<TreeNode> dias = new List<>();
        paciente.children = dias;

        while (true) {
            System.out.println(paciente.key);
            System.out.println("Seleccione día de 1 a 5 (-1 para mostrar información / -2 para salir): ");
            int selectedDay = scanner.nextInt();
            if (selectedDay == -2) {
                break;
            } else if (selectedDay == -1) {
                Tree.printTree(paciente, 0);
                continue;
            }

            TreeNode dia = Day.getDayNodeOrCreateNew(dias, selectedDay);
            if (dia != null) {
                Food.modifyDay(dia, scanner);
            }
        }

        scanner.close();
    }

}