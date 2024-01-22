public class ListFoodRegimen {
    private FoodRegimenNode first = null;

    private int size = 0;

    public int size(){
        return this.size;
    }

    public void insertFoodRegimen(String value){
        FoodRegimenNode newNode = new FoodRegimenNode(value);
        if (this.first == null) {
            this.first = newNode ;
        } else {
            FoodRegimenNode iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        this.size ++;
    }

    public String[] listFoodRegiment() {
        String[] list = new String[this.size()];
        FoodRegimenNode iterator = this.first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getFoodRegimen();
            System.out.println(iterator.getFoodRegimen());
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}
