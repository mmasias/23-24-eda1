import java.util.Random;

public class Cliente {
    private int packs;

    public Cliente() {
        this.packs = new Random().nextInt(11) + 5;
    }

    public int getPacks() {
        return packs;
    }
}
