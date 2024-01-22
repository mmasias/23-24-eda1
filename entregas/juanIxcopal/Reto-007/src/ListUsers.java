public class ListUsers {
    private User first = null;

    private int size = 0;

    public int size(){
        return this.size;
    }

    public void insertUser(String value){
        User newNode = new User(value);
        if (this.first == null) {
            this.first = newNode ;
        } else {
            User iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        this.size ++;
    }

    public String[] listAllUsers() {
        String[] list = new String[this.size()];
        User iterator = this.first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getName();
            System.out.println(iterator.getName());
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}
