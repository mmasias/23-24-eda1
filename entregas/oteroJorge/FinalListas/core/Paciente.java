import generica.GenericList;

public class Paciente {

    private String nombre;
    private String fechaDeAlta;
    private GenericList<Dia> dias;


    public Paciente(String nombre, String fechaDeAlta) {
        this.nombre = nombre;
        this.fechaDeAlta = fechaDeAlta;
        this.dias = new GenericList<Dia>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void addDia(Dia dia) {
        this.dias.insertEnd(dia);
    }

    public GenericList<Dia> getDias() {
        return dias;
    }

}
