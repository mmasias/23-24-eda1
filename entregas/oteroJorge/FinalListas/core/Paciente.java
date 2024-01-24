import generica.GenericList;
import generica.GenericNode;

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

    public void getDias() {
        GenericNode<Dia> iterator = this.dias.getFirst();
        while (iterator != null) {
            System.out.println("   " + iterator.getValue().getDia());
            iterator.getValue().getIngestas();
            iterator = iterator.getNext();
        }
    }

    public void insertarDia(){
        for(int i=1; i<=5; i++){
            Dia dia = new Dia(i);
            dia.insertarIngesta();
            this.addDia(dia);
        }
    }

}
