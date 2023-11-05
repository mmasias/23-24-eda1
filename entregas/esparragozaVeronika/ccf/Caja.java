package ccf;

public class Caja {
    private int idCaja;
    private boolean estaVacia;
    private int itemsEnCaja;
    private int personasAtendidas;
    private int itemsVendidosCaja = 0;

    public Caja(int idCaja, boolean estaVacia) {
        this.idCaja = idCaja;
        this.estaVacia = estaVacia;
        this.itemsEnCaja = 0;
        this.personasAtendidas = 0;
    }

    public boolean estaLibre() {
        return estaVacia;
    }

    public void atenderCliente(Persona cliente) {
        estaVacia = false;
        itemsEnCaja = cliente.getPackItem();
        itemsVendidosCaja += itemsEnCaja;
        personasAtendidas++;
        System.out.println("Caja " + idCaja + " atiende a un cliente con " + cliente.getPackItem() + " items.");
    }

    public void avanzarItems() {
        if (itemsEnCaja > 0) {
            itemsEnCaja--;
        } else {
            estaVacia = true;
        }
    }

    public int getIdCaja() {
        return idCaja;
    }

    public int getPersonasAtendidas() {
        return personasAtendidas;
    }
    public int getItemsEnCaja() {
        return itemsEnCaja;
    }

    public int getItemsVendidosCaja() {
        return itemsVendidosCaja;
    }
}
