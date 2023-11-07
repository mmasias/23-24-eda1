
public class Caja{   
    private Cliente cliente=null;  
    int totalpacks=0;       
    public boolean getVacia()
    {
        if(this.getNumPacksPendientes()==0)
            return true;
        else    
            return false;
    } 
    public Cliente getCliente()
    {
        if (this.cliente!=null)
            return this.cliente;
        else    
            return null;

    }
    public void setCliente(Cliente cli)
    {       
        this.cliente=cli;         
    }
    public void clienteocupacaja()
    {
         if (this.cliente!=null)
         {            
                this.cliente.restaPackPendientes();   
                if(this.cliente.getPackPendientes()==0) 
                    this.totalpacks=this.totalpacks+this.cliente.getNumeroPackCli(); 
         }
    } 
    public int getTotalPackProcesadosCaja()
    {
        return this.totalpacks;
    }
    public int getNumPacksPendientes() {
         if (this.cliente!=null)
            return this.cliente.getPackPendientes();
         else
            return 0;
    }

   

}