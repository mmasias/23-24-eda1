import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nombre;
    private double peso;
    private int altura;
    private int edad;
    private char sexo;
    private String dni;
    private LocalDate fechaAlta;
    private List<Encuesta> encuestas;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.encuestas = new ArrayList<>();
    }



    public double calcularIMC() {
        double alturaEnMetros = altura / 100.0;
        return peso / (alturaEnMetros * alturaEnMetros);
    }

    public void agregarEncuesta(Encuesta encuesta) {
        encuestas.add(encuesta);
    }

    public Encuesta buscarEncuesta(LocalDate fecha) {
        for (Encuesta encuesta : encuestas) {
            if (encuesta.getFechaEncuesta().equals(fecha)) {
                return encuesta;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente: ").append(nombre).append("\n")
                .append("Peso: ").append(peso).append(" kg\n")
                .append("Altura: ").append(altura).append(" cm\n")
                .append("Edad: ").append(edad).append("\n")
                .append("Sexo: ").append(sexo).append("\n")
                .append("DNI: ").append(dni).append("\n")
                .append("IMC: ").append(String.format("%.2f", calcularIMC())).append("\n")
                .append("Fecha de alta: ").append(fechaAlta).append("\n");

        for (Encuesta encuesta : encuestas) {
            sb.append(encuesta.toString()).append("\n");
        }
        return sb.toString();
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public List<Encuesta> getEncuestas() {
        return encuestas;
    }
    
}
