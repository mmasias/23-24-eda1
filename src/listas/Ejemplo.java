package listas;

class Ejemplo {

    public static void main(String[] args) {
        
        Participant JohnAppleseed = new Participant("John Appleseed", "United States", null);
        Participant JohnDoe = new Participant("John Doe", "Canada", null);
        Participant JaneDoe = new Participant("Jane Doe", "United Kingdom", null);
        
        Marathon marathon = new Marathon();

        marathon.addParticipant(JohnAppleseed);
        marathon.addParticipant(JohnDoe);
        marathon.addParticipant(JaneDoe);

        Node<String> currentExpected = marathon.getParticipantNames().getFirst();
        while (currentExpected != null) {
            System.out.println(currentExpected.getData());
            currentExpected = currentExpected.getNext();
        }

    }
}
