package ProyectoFinal;

public class Paciente {
    private String nombre;
    private List<DiaAlimentacion> diasAlimentacion;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.diasAlimentacion = new List<>();
    }

    public void agregarDiaAlimentacion(DiaAlimentacion dia) {
        this.diasAlimentacion.add(dia);
    }

    public DiaAlimentacion buscarDiaAlimentacion(int numeroDia) {
        Node<DiaAlimentacion> current = this.diasAlimentacion.getHead();
        while (current != null) {
            if (current.getData().getNumeroDia() == numeroDia) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DiaAlimentacion> getDiasAlimentacion() {
        return diasAlimentacion;
    }

}
