public class Cliente {
    private int numpack=15;
    private int packsPendientes=0;

    public Cliente(int numeropacks)
    {
        if (numeropacks>=5 && numeropacks<=15)       
        { 
            this.numpack=numeropacks;
            this.packsPendientes=this.numpack;        
        }
    }
    public int getNumeroPackCli()
    {
        return this.numpack;
    }   
    public void setPacksPendientes(int nro)
    {
        this.packsPendientes=nro;
    }
    public int getPackPendientes() {
        return this.packsPendientes;
    }
    public void restaPackPendientes() {
        this.packsPendientes=this.packsPendientes-1;
    }
}
