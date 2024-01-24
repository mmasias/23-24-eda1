package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public void capturarDatos() {
        System.out.println("Introduzca los datos del paciente");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Fecha de alta (dd/MM/yyyy): ");
        String fecha = sc.nextLine();
        LocalDate fechaDeAlta;
        try {
            fechaDeAlta = LocalDate.parse(fecha, formato);
        } catch (Exception e) {
            System.out.println("Fecha en formato incorrecto. Por favor, introduzca la fecha en el formato dd/MM/yyyy.");
            return;
        }

        Paciente nuevoPaciente = new Paciente(nombre, fechaDeAlta);
        pacientes.insertarOrdenado(nuevoPaciente);
        System.out.println("Paciente agregado correctamente.");
    }

    public void mostrar() {
        System.out.println("Pacientes:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(pacientes.getObjeto(i).getInformacion());
        }
    }
}
