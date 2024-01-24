public class Survey {
    private Tree<Days> daysTree;

    public Survey() {
        this.daysTree = new Tree<>();
        for (int i = 1; i <= 5; i++) {
            daysTree.insert(new Node<>(new Days(i), i));
        }
    }

    public void addFood(Food food, int day, String intakeType) {
        Node<Days> diaNode = daysTree.find(day);
        if (diaNode != null) {
            diaNode.getData().addFood(food, intakeType);
        } else {
            System.out.println("Invalid Day");
        }
    }

    public void getDietInfo() {
        StringBuilder sb = new StringBuilder();
        daysTree.printInOrder(sb);
        System.out.println(sb.toString());
    }
}