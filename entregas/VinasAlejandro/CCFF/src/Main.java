import java.util.Random;

public class Main {   
    public static void main(String[] args) 
    {
      Random random = new Random();
      int objetos = 0;
      int minutoscolacero=0;
      int minutos=0;
      String cadenaimpr="";

      int llegaGente= random.nextInt(10);
      Cola cola=new Cola();
      
      while(minutos<=720)       
      {               
        //Lo primero en cada minuto es 
        //Primero decremento pack en cajas
        //Compruebo si se queda alguna vacía que puedo aprovechar para meter cliente de la cola
        cola.restaPackCajas();   
        cola.compruebaHuecoCajas();
        cadenaimpr="";
        //Después si en ese minuto llega gente la gestiono.
        if (llegaGente < 4)
        { //40% LLega cliente
            objetos=random.nextInt(11) + 5; //Generamos número entre 0 y 10 y le sumamos 5 para estar entre 5 y 15
            Cliente cli=new Cliente(objetos);
            cola.llegaCliente(cli);
            cadenaimpr="MINUTO "+ String.valueOf(minutos)+" Llega 1 persona con " + objetos +" packs - "+ " En Cola: "+ cola.tamanoCola();  
        }
        else            
            cadenaimpr="MINUTO "+ String.valueOf(minutos)+" No llega nadie -"+ " En Cola:"+ " "+String.valueOf(cola.tamanoCola())+" ";
              
        if (cola.tamanoCola()==0)
            minutoscolacero++;
        
        llegaGente= random.nextInt(10); 
        minutos++;
        //IMPRESIONES A TERMINAL
        System.out.println(cadenaimpr);
        //cola.imprimedatos();  Para sacar toda la info de la cola
        cadenaimpr="";
        for (int i=0;i<=3;i++)                  
            cadenaimpr=cadenaimpr+" | Caja"+String.valueOf(i+1)+":[" + String.valueOf(cola.getCajas()[i].getNumPacksPendientes())+ "]";                       
        System.out.println(cadenaimpr.substring(3));
    }
    System.out.println("RESUMEN");
    System.out.println("===========================================");
    System.out.println("Personas en la cola al cierre : "+cola.tamanoCola());
    System.out.println("Minutos con cola en cero clientes:"+minutoscolacero);
    System.out.println("Personas atendidas en el dia:"+ (cola.getTotalClientes()-cola.tamanoCola()));
    System.out.println("Articulos vendidos en el dia :"+ cola.getTotalPackProcesadosCajas());
    System.out.println("===========================================");

    
  }
}