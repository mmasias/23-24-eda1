import java.util.ArrayList;
import java.util.List;

public class Cola {
    private List<Cliente> clientes=null;
    private Caja[] cajas = null;
    int totalclientes=0;
    int totalpacks=0;
    
    public Cola()
    {
        //Creamos las cajas que atenderán a la cola
        cajas=new Caja[4];
        for (int i=0;i<=3;i++)
            cajas[i]=new Caja();
        //Cuando creamos la cola está vacía y no tiene clientes
        clientes=new ArrayList<Cliente>();
    }
    public Caja[] getCajas()
    {
        return this.cajas;
    }
    public List<Cliente> getClientes()
    {
        return this.clientes;
    }
    public int getTotalClientes()
    {
        return this.totalclientes;
    }
    public int getTotalPackProcesadosCajas()
    {
        int acum=0;
        for(Caja cj :this.cajas)
            acum+=cj.getTotalPackProcesadosCaja();
        return acum;
    }
    public int tamanoCola()
    {
        return this.clientes.size();
    }   
    public void llegaCliente(Cliente cli)
    {
        totalclientes++;         
        int numprimeracajavacia=-1;  
        numprimeracajavacia=this.haycajaVacia();
        if (numprimeracajavacia!=-1)
        {
            if (this.clientes.isEmpty())            
                this.clienteACaja(numprimeracajavacia,cli);            
            else
            {
                this.clienteACaja(numprimeracajavacia,this.clientes.get(0));
                System.out.println("Cliente 0 a caja "+numprimeracajavacia);               
                this.clientes.remove(0);
                this.clientes.add(cli);
            }
        }
        else
            this.clientes.add(cli);        
    }
    private void clienteACaja(int numcaja, Cliente client) {       

        this.cajas[numcaja].setCliente(client);
    }   
    private int haycajaVacia() {
        for (int i=0;i<=3;i++)
        {
            if (this.cajas[i].getVacia())            
                return i;            
        }
        return -1;
    }
    public void restaPackCajas()
    {
        for (int i=0;i<=3;i++)
        {           
            if (!this.cajas[i].getVacia())            
                this.cajas[i].clienteocupacaja(); 
        }
    }
    public void compruebaHuecoCajas()
    {
        for (int i=0;i<=3;i++)
        {
            if (this.cajas[i].getVacia() && !this.clientes.isEmpty())            
            {
                ((Caja)this.cajas[i]).setCliente(this.clientes.get(0));                
                this.clientes.remove(0);
            }                         
        }
    }
    public void imprimedatos()
    {
        int i=0;
        for(Cliente cli :this.clientes)
        {
            System.out.println("Cola: Cli "+i+" - "+ cli.getNumeroPackCli()+ " packs.");
            i++;
        }

    }
    
}
