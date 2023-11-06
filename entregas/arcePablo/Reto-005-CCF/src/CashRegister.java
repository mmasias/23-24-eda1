import Utils.List;

public class CashRegister {
    private Client client;

    public CashRegister () {
        client = null;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
