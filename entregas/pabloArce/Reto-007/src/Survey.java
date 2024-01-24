import utils.TreeObject;

public class Survey implements TreeObject {
    private String name;
    public Survey(String name){
        this.name = name;
    }
    @Override public String toString() {
        return name;
    }
    @Override public Object getDetails(){
        return name;
    }
}
