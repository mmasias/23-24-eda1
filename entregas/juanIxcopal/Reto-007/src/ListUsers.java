public class ListUsers {
    private UserNode first = null;

    private int size = 0;

    public int size(){
        return this.size;
    }

    public void insertUser(String value){
        UserNode newNode = new UserNode(value);
        if (this.first == null) {
            this.first = newNode ;
        } else {
            UserNode iterator = this.first;
            while (iterator.getNextUser() != null) {
                iterator = iterator.getNextUser();
            }
            iterator.setNextUser(newNode);
        }
        this.size ++;
    }

    public String[] listAllUsers() {
        if (this.size() == 0) {
            System.out.println("Sin usuarios");
            return new String[0];
        }

        String[] list = new String[this.size()];
        UserNode iterator = this.first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getName();
            System.out.println(iterator.getName());
            count++;
            iterator = iterator.getNextUser();
        }
        return list;
    }

    public UserNode getUserNode(String userName) {
        UserNode iterator = this.first;
        while (iterator != null) {
            if (iterator.getName().equalsIgnoreCase(userName)) {
                return iterator;
            }
            iterator = iterator.getNextUser();
        }
        return null;
    }
}
