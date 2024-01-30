package entregas.joseLuisRodriguezGonzalez.examen_final;

public class Days {
    private int dayIndex;
    private Tree<IntakeType> intakeTree;

    public Days(int dayIndex) {
        this.dayIndex = dayIndex;
        this.intakeTree = new Tree<>();
        for (String intakeType : getValidInktakeType()) {
            intakeTree.insert(new Node<>(new IntakeType(intakeType, new Intakes()), intakeType.hashCode()));
        }
    }

    public void addFood(Food food, String intakeType) {
        Node<IntakeType> ingestaTipoNode = intakeTree.find(intakeType.hashCode());
        if (ingestaTipoNode != null) {
            ingestaTipoNode.getData().getIntakes().addFood(food);
        } else {
            System.out.println("Invalid Intake Type");
        }
    }

    private static String[] getValidInktakeType() {
        return new String[]{"Breakfast", "Midmorning", "Lunch", "Snack", "Dinner"};
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append("Día ").append(dayIndex).append(":\n");
    
        for (String intakeType : getValidInktakeType()) {
            Node<IntakeType> ingestaTipoNode = intakeTree.find(intakeType.hashCode());
            if (ingestaTipoNode != null) {
                sb.append(" ").append("Ingesta ").append(intakeType).append(":\n");
                sb.append(ingestaTipoNode.getData().getIntakes().toStringIndented());
            }
        }
    
        return sb.toString();
    }
}
