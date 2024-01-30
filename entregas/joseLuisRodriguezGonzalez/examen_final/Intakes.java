package entregas.joseLuisRodriguezGonzalez.examen_final;

public class Intakes {
    private List<Food> fooList;

    public Intakes() {
        this.fooList = new List<>();
    }

    public void addFood(Food food) {
        fooList.add(food);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<Food> current = fooList.getHead();
        while (current != null) {
            sb.append(current.getData().getName());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }

    public void listFood() {
        Node<Food> current = fooList.getHead();
        while (current != null) {
            System.out.println("\t - " + current.getData().getName());
            current = current.getNext();
        }
    }
    
    public String toStringIndented() {
        StringBuilder sb = new StringBuilder();
        Node<Food> current = fooList.getHead();
        while (current != null) {
            sb.append("    ").append("- ").append(current.getData().getName()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }
}