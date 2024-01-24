import java.util.ArrayList;
import java.util.List;

/* Clase para los datos de cada comida
 * Tendrá su identificador, su nombre y las ingestas de esa comida
 * ej: 1 Desayuno : Leche, cacao, naranja
*/

public class comida {
    /* Cada comida será una lista de alimentos */
    
    String nombre="";
    List<String> alimentos=null;
    public comida(String nom)
    {
        this.nombre=nom;
        alimentos=new ArrayList<String>();
    }
    public String getNombre()
    {
        return this.nombre;
    }
    public void setNombre(String nom)
    {
        this.nombre=nom;
    }
    public void anadealimento(String dato)
    {
        this.alimentos.add(dato);
    }
    public String alimentos()
    {
        String resultado="";
        resultado="\t"+"\t"+ this.nombre + ":"+ "\n";
        for (String elemento : alimentos){
            resultado+="\t"+"\t"+"\t"+elemento+"\n";
        }
        return resultado;
    }


}
