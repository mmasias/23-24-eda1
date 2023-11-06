import Utils.List;
public class Client {
    private int itemsNumber;

    public Client () {
        itemsNumber = generateItemNumbers();
    }

    private int generateItemNumbers() {
        int randomNumber = (int) (Math.random() * 11) + 5;
        return randomNumber;
    }

    public int getItemsNumber() {
        return itemsNumber;
    }

    public void setItemsNumber(int itemsNumber) {
        this.itemsNumber = itemsNumber;
    }
}
