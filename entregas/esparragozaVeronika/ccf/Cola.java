package ccf;

public class Cola {
    private List<Persona> personasEnCola;
    public Cola() { personasEnCola = new List<>(); }

    public void nuevoCliente() {
        double probabilidadLlegada = Math.random();
        if (probabilidadLlegada > 0.6) {
            Persona cliente = new Persona();
            System.out.println("Llegó un cliente con " + cliente.getPackItem() + " items.");
            personasEnCola.insertar(cliente);
        }
    }

    public Persona eliminarCliente() { return personasEnCola.delete(); }
    public boolean isEmpty() { return personasEnCola.isEmpty(); }
    public int size() { return personasEnCola.size(); }
}