public class dia {    
    
    comida[] comidas=null;
    public dia()
    {           
        comidas=new comida[5]; /*Array de 5 elementos para recibir 5 comidas*/        
        for (int i=0;i<nomComidas.values().length;i++) {
            comidas[i]=new comida(String.valueOf(nomComidas.values()[i]));
        }
    }   
    public comida[] getComidas()
    {
        return this.comidas;
    }
    public void anadeIngestaAComida(int identComida,String nomalimento)
    {
        this.comidas[identComida].anadealimento(nomalimento);        
    }
}
