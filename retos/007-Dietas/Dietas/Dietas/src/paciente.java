public class paciente {
    String nombrePaciente="";
    dia[] listadias = null;

    public paciente(String nombre)
    {
        this.nombrePaciente=nombre;
        listadias= new dia[5];       
    }
    public String getNombre()
    {
        return this.nombrePaciente;
    }
    public void anadedia(int numero)
    {
        this.listadias[numero]=new dia();
    }
    public dia[] getListaDias()
    {
        return this.listadias;
    }


    
}
