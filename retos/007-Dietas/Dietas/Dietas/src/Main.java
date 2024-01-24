import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<paciente> pacientes=null; 
    public static void main(String[] args) {        
            creaEncuesta();
    }
    public static void creaEncuesta() {

        System.out.println("Encuesta sobre alimentacion");
        System.out.println("A. Introducir datos pacientes.");
        System.out.println("B. Muestra datos pacientes.");        
        System.out.println("C. Completa paciente empezado.");
        System.out.println("D. Salir");
        System.out.println("Elija la opción que desea:");
        pacientes=new ArrayList<paciente>();
        Scanner sc = new Scanner(System.in);
        String opcion = sc.nextLine();

        while (opcion.compareTo("D")!=0)
        {
            switch (opcion) {
                case "A":
                    System.out.println("Indique el nombre del paciente:");                    
                    String nombre = sc.nextLine();
                    System.out.println("Se procede a realizar la encuesta para " + nombre);

                    paciente pac=new paciente(nombre);
                    System.out.println("Indique que dia va ha añadir (1-5)");        
                    int dia = sc.nextInt();                       
                    pac.anadedia(dia-1);        
    
                    System.out.println("Seleccione ingesta:0 (Terminar) / 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)");
                    int ingesta = sc.nextInt();
    
                    while (ingesta!=0){
                        /* Vamos a introducir alimentos de ingestas de un día de un paciente */
                        System.out.println("Introduzca el primer alimento de la ingesta:(Q para terminar))");
                        String alimento=sc.next();                
                        while (alimento.compareTo("")!=0 && alimento.compareTo("Q")!=0)
                        {
                            pac.listadias[dia-1].anadeIngestaAComida(ingesta-1, alimento);
                            System.out.println("Introduzca el siguiente alimento de la ingesta:(Q para terminar))");
                            alimento=sc.next();                            
                        }
                        System.out.println("¿Desea introducir una ingesta del mismo día y paciente?");
                        String res=sc.next();
                        if (res.compareTo("Si")==0)
                        {
                            System.out.println("Seleccione ingesta:0 (Terminar) / 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)");
                            ingesta = sc.nextInt();
                        }
                        else
                            ingesta=0;
                    }
                    pacientes.add(pac);                
                    break;
                case "B":                
                    System.out.println(muestraDatosPacientes());
                    break;
                case "C":
                    System.out.println("Indique el nombre del paciente:");                    
                    nombre = sc.nextLine();
                    System.out.println("Se procede a buscar al paciente " + nombre);
                    int num=buscaPaciente(nombre);           
                    if (num!=-1)
                    {
                        System.out.println("Indique que dia va ha añadir (1-5)");        
                        dia = sc.nextInt();                       
                        pacientes.get(num).anadedia(dia-1);        
        
                        System.out.println("Seleccione ingesta:0 (Terminar) / 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)");
                        ingesta = sc.nextInt();
        
                        while (ingesta!=0){
                        /* Vamos a introducir alimentos de ingestas de un día de un paciente */
                            System.out.println("Introduzca el primer alimento de la ingesta:(Q para terminar))");
                            String alimento=sc.next();                
                            while (alimento.compareTo("")!=0 && alimento.compareTo("Q")!=0)
                            {
                                pacientes.get(num).listadias[dia-1].anadeIngestaAComida(ingesta-1, alimento);
                                System.out.println("Introduzca el siguiente alimento de la ingesta:(Q para terminar))");
                                alimento=sc.next();                                
                            }
                            System.out.println("¿Desea introducir una ingesta del mismo día y paciente?Si-No");
                            String res=sc.next();
                            if (res.compareTo("Si")==0)
                            {
                                System.out.println("Seleccione ingesta:0 (Terminar) / 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)");
                                ingesta = sc.nextInt();
                            }
                            else
                                ingesta=0;
                        }
                    } 
                    else{
                        System.out.println("El paciente no se ha encontrado.");
                    }
                    break;                   
            }  
            /*Refactorizar */
            System.out.println("Encuesta sobre alimentacion");
            System.out.println("A. Introducir datos pacientes.");
            System.out.println("B. Muestra datos pacientes.");
            System.out.println("C. Completa paciente empezado.");            
            System.out.println("D. Salir");
            System.out.println("Elija la opción que desea:");        
            sc = new Scanner(System.in);
            opcion = sc.nextLine();
        }       
        sc.close();
    }  
    
    private static int buscaPaciente(String nom)
    {
        int t=0;
        for (paciente pacibus : pacientes) {
            t++;    
            if (pacibus.getNombre().compareTo("nombre")==0)            
                return t;                            
        }
        return -1;         
    }
    private static String muestraDatosPacientes()
    {
        String res="";
        for (paciente paci : pacientes) {
            res+="\n"+"Paciente: "+paci.getNombre() +"\n";
            for (int i=0;i<5;i++)
            {
                res+="\t"+"Día " + String.valueOf(i+1)+ "\n";
                if (paci.listadias[i]!=null)
                {
                    for (int j=0;j<5;j++)                                            
                        res+=paci.listadias[i].getComidas()[j].alimentos()+"\n";
                    
                }
            }
        }        
        return res;
    }
    
    }
