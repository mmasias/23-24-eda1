public class Food {
    private String name;
    public Food(String name) {
        setName(name);
    }
    @Override
    public String toString() {
        return name;
    }
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
    }
}
