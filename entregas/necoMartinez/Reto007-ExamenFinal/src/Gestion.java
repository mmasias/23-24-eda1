package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestion {
    private GenericList<Paciente> pacientes;
    private Scanner sc;
    private DateTimeFormatter formato;

    public Gestion() {
        this.pacientes = new GenericList<>();
        this.sc = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void insertarPaciente() {
        System.out.println("Introduce el nombre del paciente");
        String nombre = sc.nextLine();
        LocalDate fechaDeAlta = null;
        boolean ok;
        do {
            ok = true;
            System.out.println("Introduce la fecha de alta del paciente (dd/mm/aaaa)");
            try {
                fechaDeAlta = LocalDate.parse(sc.nextLine(), formato);
            } catch (Exception e) {
                System.out.println("Fecha incorrecta");
                ok = false;
            }
        } while (!ok);

        Paciente paciente = new Paciente(nombre, fechaDeAlta);
        this.pacientes.insertarOrdenado(paciente);
    }

    public void mostrarPacientes() {
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(pacientes.getObjeto(i).getInformacion());
        }
    }
}
