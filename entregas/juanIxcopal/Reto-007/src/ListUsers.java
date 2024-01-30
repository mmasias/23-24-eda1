public class ListUsers {
    private UserNode first = null;

    private int size = 0;

    public int size(){
        return this.size;
    }

    public void insertUser(String value){
        UserNode newUserNode = new UserNode(value);
        if (this.first == null) {
            this.first = newUserNode ;
        } else {
            UserNode userNodeIterator = this.first;
            while (userNodeIterator.getNextUser() != null) {
                userNodeIterator = userNodeIterator.getNextUser();
            }
            userNodeIterator.setNextUser(newUserNode);
        }
        this.size ++;
    }

    public String[] listAllUsers() {
        if (this.size() == 0) {
            System.out.println("!!----- No existen usuarios registrados -----!!");
            return new String[0];
        }

        String[] listUsers = new String[this.size()];
        UserNode userNodeIterator = this.first;
        int count = 0;
        while (userNodeIterator != null) {
            listUsers[count] = userNodeIterator.getUserName();
            System.out.print("Nombre de usuario: " + userNodeIterator.getUserName() + " -- ");
            System.out.println(" Fecha de alta: " + userNodeIterator.getDischargeDate());
            count++;
            userNodeIterator = userNodeIterator.getNextUser();
        }
        return listUsers;
    }

    public UserNode getUserNode(String userName) {
        UserNode userNodeIterator = this.first;
        while (userNodeIterator != null) {
            if (userNodeIterator.getUserName().equalsIgnoreCase(userName)) {
                return userNodeIterator;
            }
            userNodeIterator = userNodeIterator.getNextUser();
        }
        return null;
    }
}
