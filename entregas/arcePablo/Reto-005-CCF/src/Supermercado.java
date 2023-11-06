import Utils.*;
public class Supermercado {
    private List<CashRegister> cashRegisterList;
    private List<Client> clientLineList;
    private boolean clientInLastMinute = false;

    public Supermercado() {
        clientLineList = new List<Client>();
        cashRegisterList = new List<CashRegister>();
        initCashRegisters();
    }

    private void initCashRegisters() {
        for (int i = 0; i < 4; i++) {
            cashRegisterList.insert(new CashRegister(), -1);
        }
    }

    public void manageClientLine(){
        if (clientLineList.size() > 0) {
            distributeClient(clientLineList.getFirst().getData());
            clientLineList.remove(0);
        }
    }

    public void generateNewClient(){
        double randomNumber = Math.random();
        boolean getsNewClient = randomNumber <= 0.4 ? true : false;
        if (getsNewClient){
            clientInLastMinute = true;
            Client newClient = new Client();
            distributeClient(newClient);
        }
    }

    public void distributeClient(Client newClient) {
        for (int i = 0; i < cashRegisterList.size(); i++) {
            Client actualClient = cashRegisterList.getIndexNode(i).getData().getClient();
            if (actualClient == null) {
                cashRegisterList.getIndexNode(i).getData().setClient(newClient);
                return;
            }
        }
        addClientToLine(newClient);
    }

    private void addClientToLine(Client newClient) {
        clientLineList.insert(newClient, -1);
    }

    public void cashItems(){
        for (int i = 0; i< cashRegisterList.size(); i++) {
            Client actualClient = cashRegisterList.getIndexNode(i).getData().getClient();
            if (actualClient != null) {
                actualClient.setItemsNumber(actualClient.getItemsNumber() - 1);
                if (actualClient.getItemsNumber() == 0) {
                    cashRegisterList.getIndexNode(i).getData().setClient(null);
                }
            }
        }
    }

    ///////// DISPLAY PART  //////////

    public void showCashRegisters() {
        for (int i = 0; i < cashRegisterList.size(); i++) {
            Client actualClient = cashRegisterList.getIndexNode(i).getData().getClient();
            if (actualClient != null) {
                System.out.println("Caja " + i + ": " + actualClient.getItemsNumber() + " items");
            } else {
                System.out.println("Caja " + i + ": " + "VACIA");
            }
        }
    }

    public void showClientInLastMinute() {
        System.out.print("LLegada de cliente: " + clientInLastMinute);
        clientInLastMinute = false;
    }

    public void showClientLine() {
        System.out.println("Cola de clientes: " + clientLineList.size());
    }
}
