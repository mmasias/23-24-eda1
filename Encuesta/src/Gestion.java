import Coleciones.Arbol;
import Coleciones.GenericList;
import Coleciones.IDataStructure;
import Coleciones.NodoArbol;
import clases.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Gestion {
    private Arbol<IDataStructure> datos;
    private DateTimeFormatter formato;
    private Scanner sc;

    public Gestion() {
        datos = new Arbol<IDataStructure>(null);
        formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        sc = new Scanner(System.in);
    }

    public void insertarActualizarPaciente() {

        if (datos.getRaiz() == null) {
            System.out.println("Introduzca nombre del paciente");
            String nombre = sc.nextLine();

            LocalDate fecha = null;
            boolean ok = true;
            do {
                ok = true;
                try {
                    System.out.println("Introduzca fecha de nacimiento(dd-mm-yyyy)");
                    fecha = LocalDate.parse(sc.nextLine(), formato);
                } catch (Exception e) {
                    ok = false;

                }
            } while (!ok);

            NodoArbol<IDataStructure> raiz = new NodoArbol<IDataStructure>(new Persona(nombre, fecha));
            datos.setRaiz(raiz);

        } else {
            System.out.println("Introduzca nuevo nombre del paciente");
            String nombre = sc.nextLine();

            LocalDate fecha = null;
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            boolean ok = true;
            do {
                ok = true;
                try {
                    System.out.println("Introduzca nueva fecha de nacimiento(dd-mm-yyyy)");
                    fecha = LocalDate.parse(sc.nextLine(), formato);
                } catch (Exception e) {
                    ok = false;
                }

            } while (!ok);
            datos.getRaiz().setValor(new Persona(nombre, fecha));
        }
    }

    public void insertarDias() {
        if (datos.getRaiz() != null) {

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fecha = null;
            boolean ok = true;

            do {
                ok = true;
                try {
                    System.out.println("Introduzca fecha de alta a participar en la encuesta(dd-mm-yyyy)");
                    fecha = LocalDate.parse(sc.nextLine(), formato);
                } catch (Exception e) {
                    ok = false;
                }
            } while (!ok);

            NodoArbol<IDataStructure> nodoEncuesta = new NodoArbol<IDataStructure>(new Encuesta(fecha));
            datos.getRaiz().agregarHijo(nodoEncuesta);

            for (int i = 1; i <= 5; i++) {
                nodoEncuesta.agregarHijo(new NodoArbol<IDataStructure>(new Dia(i)));
            }
        }
    }


    public void insertarIngesta() throws Exception {
        System.out.println("hay " + datos.getRaiz().getHijos().getValorPorPosicion(0).getHijos().size() + " dias");

        int dia = 0;
        boolean ok = true;

        do {
            do {
                ok = true;
                System.out.println("Seleccione día / -1 (Salir)");

                try {
                    sc = new Scanner(System.in);
                    dia = sc.nextInt();


                    sc.nextLine();

                    if ((dia < 1 || dia > datos.getRaiz().getHijos().getValorPorPosicion(0).getHijos().size()) && dia != -1) {
                        System.out.println("El día seleccionado no existe");
                        ok = false;
                    }
                    if (dia == -1) {
                        throw new Exception("Salir");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Día no válido");
                    ok = false;
                }

                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate fecha = null;
                boolean ok2;

                do {
                    ok2 = true;
                    try {
                        System.out.println("Introduzca la fecha del día elegido anteriormente (dd-mm-yyyy)");
                        fecha = LocalDate.parse(sc.nextLine(), formato);
                    } catch (Exception e) {
                        ok2 = false;
                    }
                } while (!ok2);


                NodoArbol<IDataStructure> nodoDia = datos.getRaiz().getHijos().getValorPorPosicion(0).getHijos().getValorPorPosicion(dia - 1);
                nodoDia.setFecha(fecha);

            } while (!ok);


            NodoArbol<IDataStructure> nodoDia = datos.getRaiz().getHijos().getValorPorPosicion(0).getHijos().getValorPorPosicion(dia - 1);


            System.out.println("---------" + nodoDia.getValor().getInformacion());
            int opcion = 0;

            do {
                System.out.println(
                        "Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menu anterior)");


                boolean salir = true;

                    opcion = sc.nextInt();
                    salir = false;
                    Ingesta ing = null;
                    Horario horario = null;

                    switch (opcion) {
                        case 1:
                            horario = Horario.DESAYUNO;
                            salir = true;
                            break;
                        case 2:
                            horario = Horario.MEDIA_MAÑANA;
                            salir = true;
                            break;
                        case 3:
                            horario = Horario.ALMUERZO;
                            salir = true;
                            break;
                        case 4:
                            horario = Horario.MERIENDA;
                            break;
                        case 5:
                            horario = Horario.CENA;
                            break;
                        case -1:
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            opcion = sc.nextInt();

                    }
                    NodoArbol<IDataStructure> nodoIngesta = existeNodoIngesta(dia, horario);
                    if (nodoIngesta != null) {
                        ing = (Ingesta) nodoIngesta.getValor();
                    } else {
                        ing = new Ingesta(horario);
                    }

                    if (opcion != -1) {
                        String opcion2 = "";

                        do {
                            System.out.println("Ingrese un alimento de " + ing.getHorario().getNombre() + " del dia " + dia
                                    + " ( -1 = para terminar / -2 = para listar alimentos ingresados / -3 = para vaciar todas las ingestas de un dia)");
                            sc = new Scanner(System.in);
                            opcion2 = sc.nextLine();
                            if (opcion2.equals("")) {
                                do {
                                    System.out.println("No ha introducido ningun valor. Ingrese el nombre del alimento que ha ingerido: ");
                                    opcion2 = sc.nextLine();
                                } while (opcion2.equals(""));
                            }
                            if (opcion2.equals("-2")) {
                                System.out.println(ing.getInformacion());
                            } else if (opcion2.equals("-3")) {
                                ing.getAlimentos().vaciar();
                            } else if (!opcion2.equals("-1")) {
                                System.out.println("Cantidad (gr.):");
                                while (!sc.hasNextInt()) {
                                    System.out.println("Error: Debe insertar una cantidad exacta. Inténtalo de nuevo.");
                                    sc.next();
                                }

                                int cantidad = sc.nextInt();

                                Alimento alimento = new Alimento(opcion2, cantidad);
                                ing.insertarAlimento(alimento);
                            }


                        } while (!opcion2.equals("-1"));


                        if (ing != null && nodoIngesta == null) {
                            nodoDia.agregarHijo(new NodoArbol<IDataStructure>(ing));
                        }
                        if (nodoIngesta != null) {
                            nodoIngesta.setValor(ing);
                        }

                    }
                } while (opcion != -1);
            } while (true);

    }

    public void capturarDatos() {
        this.insertarActualizarPaciente();

        this.insertarDias();
        boolean salir = false;
        do {
            salir = false;
            try {
                this.insertarIngesta();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                salir = true;
            }

        } while (!salir);

    }

    public void mostrar() {
        datos.recorridoPreOrden(datos.getRaiz());
    }


    public NodoArbol<IDataStructure> existeNodoIngesta(int dia, Horario horario) {
        NodoArbol<IDataStructure> result = null;

        NodoArbol<IDataStructure> nodoDia = datos.getRaiz().getHijos().getValorPorPosicion(0).getHijos()
                .getValorPorPosicion(dia - 1);
        GenericList<NodoArbol<IDataStructure>> nodosIngesta = nodoDia.getHijos();
        for (int i = 0; i < nodosIngesta.size(); i++) {
            Ingesta ing = (Ingesta) nodosIngesta.getValorPorPosicion(i).getValor();
            if (ing.getHorario() == horario) {
                result = nodosIngesta.getValorPorPosicion(i);
                break;
            }
        }

        return result;
    }
    public void estadisticas() {
        int totalCalorias = datos.totalCaloriasEnc(datos.getRaiz());
        int totalAzucar = datos.totalAzucarEnc(datos.getRaiz());
        int totalGrasas = datos.totalGrasasEnc(datos.getRaiz());
        int totalProteinas = datos.totalProteinasEnc(datos.getRaiz());
        String rojo = "\u001B[31m";
        String azul="\u001B[34m";
        String verde="\u001B[32m";
        String amarillo="\u001B[33m";
        String resetColor = "\u001B[0m";

        System.out.println("Otros: " + datos.totalTipoEnc(datos.getRaiz(), "Otros"));
        System.out.println("Total calorias en cinco días: " + totalCalorias);
        System.out.println("Promedio diario: " + totalCalorias / 5);


        if (totalCalorias / 5 < 1600) {
            System.out.println(amarillo+"Consumo de calorias por debajo de las recomendadas"+resetColor);
        } else if (totalCalorias / 5 > 2500) {
            System.out.println(rojo+"Consumo de calorias excesivo. Se recomienda aumentar el ejercicio físico"+resetColor);
        } else {
            System.out.println(verde+"Consumo correcto de calorías"+resetColor);
        }

        System.out.println("Total de azucar consumida en cinco días: " + totalAzucar);
        System.out.println("Promedio diario: " + totalAzucar / 5);
        if (totalAzucar / 5 <= 25) {
            System.out.println(verde+"Consumo de azucar correcto"+resetColor);
        } else {
            System.out.println(rojo+"Consumo excesivo de azucar. Debe reducir el consumo"+resetColor);
        }

        System.out.println("Total de proteinas en cinco días: " + totalProteinas);
        System.out.println("Promedio diario: " + totalProteinas / 5);
        if (totalProteinas / 5 < 40) {
            System.out.println(amarillo+"Consumo bajo en proteinas. Debe e,pezar a ingerir alimentos con mas proteinas"+resetColor);
        }else if (totalProteinas/5 >60){
            System.out.println(rojo+"Consumo alto de proteinas. Debe reducir el consumo"+resetColor);
        }else {
            System.out.println(verde+"El consumo de proteinas se encuentra dentro de los valores correctos"+resetColor);
        }


        System.out.println("Total de grasas consumida en cinco días: " + totalGrasas);
        System.out.println("Promedio diario: " + totalGrasas / 5);
        if(totalGrasas/5<200){
            System.out.println(amarillo+"Consumo bajo de grasas"+resetColor);
        }else if (totalGrasas/5>220){
            System.out.println(rojo+"Consumo alto de grasas.DEBE REDUCIR EL CONSUMO A 200 (gr)"+resetColor);
        }else {
            System.out.println(verde+"Consumo correcto correcto de grasas"+resetColor);
        }
        System.out.println("");

        System.out.println("Fruta: " + datos.totalTipoEnc(datos.getRaiz(), "Fruta"));
        if (datos.totalTipoEnc(datos.getRaiz(), "Fruta")/5<2){
            System.out.println(rojo+"Debes comer más fruta al dia+"+resetColor);
        } else {
            System.out.println(verde+"Comer fruta es muy sano. SIGUE ASI"+resetColor);
        }
        System.out.println("");

        System.out.println("Frutos Secos: " + datos.totalTipoEnc(datos.getRaiz(), "Frutos secos"));
        if (datos.totalTipoEnc(datos.getRaiz(), "Frutos secos")/5<4){
            System.out.println(rojo+"Debes comer más fruta al dia+"+resetColor);
        } else if (datos.totalTipoEnc(datos.getRaiz(), "Frutos secos")/5>5){
            System.out.println(rojo+"Consumo alto de frutos secos.Debe ingerir 20-25 gramos al dia"+resetColor);
        }
        else {
            System.out.println(verde+"Comer Frutos Secos es muy sano. SIGUE ASI"+resetColor);
        }
        System.out.println("");

        System.out.println("Verdura: " + datos.totalTipoEnc(datos.getRaiz(), "Verdura"));
        if (datos.totalTipoEnc(datos.getRaiz(), "Verdura")/5<2){
            System.out.println(rojo+"Debes comer más Verduras al dia+"+resetColor);
        } else {
            System.out.println(verde+"Comer Verduras es muy sano. SIGUE ASI"+resetColor);
        }
        System.out.println("");

        System.out.println("Lacteo: " + datos.totalTipoEnc(datos.getRaiz(), "Lacteo"));
        if (datos.totalTipoEnc(datos.getRaiz(), "Lacteo")/5<2){
            System.out.println(rojo+"Debes comer más lacteos al dia+"+resetColor);
        } else if (datos.totalTipoEnc(datos.getRaiz(), "Lacteo")/5>4){
            System.out.println(rojo+"Consumo alto de lacteos.Debe ingerir 2-3 lacteos al dia"+resetColor);
        }
        else {
            System.out.println(verde+"Comer "+datos.totalTipoEnc(datos.getRaiz(), "Lacteo")/5 +" lacteos es muy sano. SIGUE ASI"+resetColor);
        }
        System.out.println("");

        System.out.println("Carne: " + datos.totalTipoEnc(datos.getRaiz(), "Carne"));
        if (datos.totalTipoEnc(datos.getRaiz(), "Carne")<3){
            System.out.println(rojo+"Debes comer más carne a la semana"+resetColor);
        } else if (datos.totalTipoEnc(datos.getRaiz(), "Carne")>5){
            System.out.println(rojo+"Consumo alto de Carne.Debe ingerir 3-5 veces carne a la semana "+resetColor);
        }
        else {
            System.out.println(verde+"Comer "+datos.totalTipoEnc(datos.getRaiz(), "Carne") +" platos de carne a la semana es muy sano. SIGUE ASI"+resetColor);
        }
        System.out.println("");

        System.out.println("Pescado: " + datos.totalTipoEnc(datos.getRaiz(), "Pescado"));
        if (datos.totalTipoEnc(datos.getRaiz(), "Pescado")<3){
            System.out.println(rojo+"Debes comer más pescado a la semana+"+resetColor);
        } else if (datos.totalTipoEnc(datos.getRaiz(), "Pescado")>5){
            System.out.println(rojo+"Consumo alto de Pescado.Debe ingerir 3-5 veces carne a la semana "+resetColor);
        }
        else {
            System.out.println(verde+"Comer "+datos.totalTipoEnc(datos.getRaiz(), "Pescado") +" platos a la semana de pescado es muy sano. SIGUE ASI"+resetColor);
        }
        System.out.println("");

        System.out.println("Dulce: " + datos.totalTipoEnc(datos.getRaiz(), "Dulce"));

        if (datos.totalTipoEnc(datos.getRaiz(), "Dulce")>5){
            System.out.println(rojo+"Consumo alto de Dulces.Debe ingerir menos dulces a la semana "+resetColor);
        }

        System.out.println("Cereal: " + datos.totalTipoEnc(datos.getRaiz(), "Cereal"));
        if (datos.totalTipoEnc(datos.getRaiz(), "Cereal")/5<5){
            System.out.println(rojo+"Debes comer más cereales al dia+"+resetColor);
        } else if (datos.totalTipoEnc(datos.getRaiz(), "Cereal")>12){
            System.out.println(rojo+"Consumo alto de cereales.Debe ingerir 5-12 raciones de cereales al dia"+resetColor);
        }
        else {
            System.out.println(verde+"Comer "+datos.totalTipoEnc(datos.getRaiz(), "Cereal") +" raciones al dia de cereales es muy sano. SIGUE ASI"+resetColor);
        }
        System.out.println("");

        System.out.println("Legumbre: " + datos.totalTipoEnc(datos.getRaiz(), "Legumbre"));
        if (datos.totalTipoEnc(datos.getRaiz(), "Legumbre")<2){
            System.out.println(rojo+"Debes comer más legumbres a la semana+"+resetColor);
        } else if (datos.totalTipoEnc(datos.getRaiz(), "Legumbre")>4){
            System.out.println(rojo+"Consumo alto de legumbres. Debe ingerir 2-4 veces legumbres a la semana "+resetColor);
        }
        else {
            System.out.println(verde+"Comer "+datos.totalTipoEnc(datos.getRaiz(), "Legumbre") +" platos a la semana de legumbres es muy sano. SIGUE ASI"+resetColor);
        }
        System.out.println("");

        System.out.println("Huevo: " + datos.totalTipoEnc(datos.getRaiz(), "Huevo"));
        if (datos.totalTipoEnc(datos.getRaiz(), "Huevo")<3){
            System.out.println(rojo+"Debes comer más huevos a la semana+"+resetColor);
        } else if (datos.totalTipoEnc(datos.getRaiz(), "Huevo")>5){
            System.out.println(rojo+"Consumo alto de Huevos. Debe ingerir 3-5 veces huevos a la semana "+resetColor);
        }
        else {
            System.out.println(verde+"Comer "+datos.totalTipoEnc(datos.getRaiz(), "Huevo") +" huevos a la semana  es muy sano. SIGUE ASI"+resetColor);
        }
        System.out.println("");

        System.out.println("Bebida: " + datos.totalTipoEnc(datos.getRaiz(), "Bebida"));




    }
}