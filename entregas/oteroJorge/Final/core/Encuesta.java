package core;

public class Encuesta {

    private String fechaDeToma;

    public Encuesta(String fechaDeToma) {
        this.fechaDeToma = fechaDeToma;
    }

    public String getFechaDeToma() {
        return fechaDeToma;
    }

    public void mostrarArbol(Paciente paciente) {
        System.out.println("Paciente: " + paciente.getNombre());
        System.out.println("Fecha de Toma: " + getFechaDeToma());

        System.out.println("  " + paciente.getDia1().getDia());
        System.out.println("    " + paciente.getDia1().getDesayuno().getNombre());
        paciente.getDia1().getDesayuno().getAlimentos();
        System.out.println("    " + paciente.getDia1().getAlmuerzo().getNombre());
        paciente.getDia1().getAlmuerzo().getAlimentos();
        System.out.println("    " + paciente.getDia1().getComida().getNombre());
        paciente.getDia1().getComida().getAlimentos();
        System.out.println("    " + paciente.getDia1().getMerienda().getNombre());
        paciente.getDia1().getMerienda().getAlimentos();
        System.out.println("    " + paciente.getDia1().getCena().getNombre());
        paciente.getDia1().getCena().getAlimentos();

        System.out.println("  " + paciente.getDia2().getDia());
        System.out.println("    " + paciente.getDia2().getDesayuno().getNombre());
        paciente.getDia2().getDesayuno().getAlimentos();
        System.out.println("   " + paciente.getDia2().getAlmuerzo().getNombre());
        paciente.getDia2().getAlmuerzo().getAlimentos();
        System.out.println("   " + paciente.getDia2().getComida().getNombre());
        paciente.getDia2().getComida().getAlimentos();
        System.out.println("   " + paciente.getDia2().getMerienda().getNombre());
        paciente.getDia2().getMerienda().getAlimentos();
        System.out.println("   " + paciente.getDia2().getCena().getNombre());
        paciente.getDia2().getCena().getAlimentos();

        System.out.println(" " + paciente.getDia3().getDia());
        System.out.println("   " + paciente.getDia3().getDesayuno().getNombre());
        paciente.getDia3().getDesayuno().getAlimentos();
        System.out.println("   " + paciente.getDia3().getAlmuerzo().getNombre());
        paciente.getDia3().getAlmuerzo().getAlimentos();
        System.out.println("   " + paciente.getDia3().getComida().getNombre());
        paciente.getDia3().getComida().getAlimentos();
        System.out.println("   " + paciente.getDia3().getMerienda().getNombre());
        paciente.getDia3().getMerienda().getAlimentos();
        System.out.println("   " + paciente.getDia3().getCena().getNombre());
        paciente.getDia3().getCena().getAlimentos();

        System.out.println("  " + paciente.getDia4().getDia());
        System.out.println("   " + paciente.getDia4().getDesayuno().getNombre());
        paciente.getDia4().getDesayuno().getAlimentos();
        System.out.println("   " + paciente.getDia4().getAlmuerzo().getNombre());
        paciente.getDia4().getAlmuerzo().getAlimentos();
        System.out.println("   " + paciente.getDia4().getComida().getNombre());
        paciente.getDia4().getComida().getAlimentos();
        System.out.println("   " + paciente.getDia4().getMerienda().getNombre());
        paciente.getDia4().getMerienda().getAlimentos();
        System.out.println("   " + paciente.getDia4().getCena().getNombre());
        paciente.getDia4().getCena().getAlimentos();

        System.out.println("  " + paciente.getDia5().getDia());
        System.out.println("   " + paciente.getDia5().getDesayuno().getNombre());
        paciente.getDia5().getDesayuno().getAlimentos();
        System.out.println("   " + paciente.getDia5().getAlmuerzo().getNombre());
        paciente.getDia5().getAlmuerzo().getAlimentos();
        System.out.println("   " + paciente.getDia5().getComida().getNombre());
        paciente.getDia5().getComida().getAlimentos();
        System.out.println("   " + paciente.getDia5().getMerienda().getNombre());
        paciente.getDia5().getMerienda().getAlimentos();
        System.out.println("   " + paciente.getDia5().getCena().getNombre());
        paciente.getDia5().getCena().getAlimentos();

    }

    public void comparacionCalorias(Paciente paciente, double caloriasTeoricas){
        double calorias = paciente.getCalorias();
        if(calorias>caloriasTeoricas){
            System.out.println("El paciente " + paciente.getNombre() + " tiene un exceso de calorias de " + (calorias-caloriasTeoricas));
        }else if(calorias<caloriasTeoricas){
            System.out.println("El paciente " + paciente.getNombre() + " tiene un deficit de calorias de " + (caloriasTeoricas-calorias));
        }
        else{
            System.out.println("El paciente " + paciente.getNombre() + " tiene un consumo de calorias adecuado");
        }
    }

    public void comparacionProteinas(Paciente paciente, double proteinasTeoricas){
        double proteinas = paciente.getProteinas();
        if(proteinas>proteinasTeoricas){
            System.out.println("El paciente " + paciente.getNombre() + " tiene un exceso de proteinas de " + (proteinas-proteinasTeoricas));
        }else if(proteinas<proteinasTeoricas){
            System.out.println("El paciente " + paciente.getNombre() + " tiene un deficit de proteinas de " + (proteinasTeoricas-proteinas));
        }
        else{
            System.out.println("El paciente " + paciente.getNombre() + " tiene un consumo de proteinas adecuado");
        }
    }

    public void comparacionGrasas(Paciente paciente, double grasasTeoricas){
        double grasas = paciente.getGrasas();
        if(grasas>grasasTeoricas){
            System.out.println("El paciente " + paciente.getNombre() + " tiene un exceso de grasas de " + (grasas-grasasTeoricas));
        }else if(grasas<grasasTeoricas){
            System.out.println("El paciente " + paciente.getNombre() + " tiene un deficit de grasas de " + (grasasTeoricas-grasas));
        }
        else{
            System.out.println("El paciente " + paciente.getNombre() + " tiene un consumo de grasas adecuado");
        }
    }

    public void comparacionCarbohidratos(Paciente paciente, double carbohidratosTeoricos){
        double carbohidratos = paciente.getCarbohidratos();
        if(carbohidratos>carbohidratosTeoricos){
            System.out.println("El paciente " + paciente.getNombre() + " tiene un exceso de carbohidratos de " + (carbohidratos-carbohidratosTeoricos));
        }else if(carbohidratos<carbohidratosTeoricos){
            System.out.println("El paciente " + paciente.getNombre() + " tiene un deficit de carbohidratos de " + (carbohidratosTeoricos-carbohidratos));
        }
        else{
            System.out.println("El paciente " + paciente.getNombre() + " tiene un consumo de carbohidratos adecuado");
        }
    }

    public void comparacionVitaminas(Paciente paciente, double vitaminasTeoricas){
        double vitaminas = paciente.getVitaminas();
        if(vitaminas>vitaminasTeoricas){
            System.out.println("El paciente " + paciente.getNombre() + " tiene un exceso de vitaminas de " + (vitaminas-vitaminasTeoricas));
        }else if(vitaminas<vitaminasTeoricas){
            System.out.println("El paciente " + paciente.getNombre() + " tiene un deficit de vitaminas de " + (vitaminasTeoricas-vitaminas));
        }
        else{
            System.out.println("El paciente " + paciente.getNombre() + " tiene un consumo de vitaminas adecuado");
        }
    }

    public void comparacionMinerales(Paciente paciente, double mineralesTeoricos){
        double minerales = paciente.getMinerales();
        if(minerales>mineralesTeoricos){
            System.out.println("El paciente " + paciente.getNombre() + " tiene un exceso de minerales de " + (minerales-mineralesTeoricos));
        }else if(minerales<mineralesTeoricos){
            System.out.println("El paciente " + paciente.getNombre() + " tiene un deficit de minerales de " + (mineralesTeoricos-minerales));
        }
        else{
            System.out.println("El paciente " + paciente.getNombre() + " tiene un consumo de minerales adecuado");
        }
    }

    public void recibirResultados(Paciente paciente){
        System.out.println("Los resultados de la encuesta son: ");
        comparacionCalorias(paciente, 2500*5);
        comparacionProteinas(paciente, 50*5);
        comparacionGrasas(paciente, 22*5);
        comparacionCarbohidratos(paciente, 135*5);
        comparacionVitaminas(paciente, 13*5);
        comparacionMinerales(paciente, 10*5);
    }

    public void tipoAlimentoMasConsumido(Paciente paciente){
        paciente.extraerTipos();
    }

    public void rellenarEncuesta(Paciente paciente) {
        System.out.println("Se ha rellenado la encuesta del paciente " + paciente.getNombre());
    
        // Día 1
        paciente.getDia1().getDesayuno().addAlimento(new Alimento("Manzana", 52, 0.26, 0.17, 13.81, 0.0003, 0.003, "Fruta/Verdura"));
        paciente.getDia1().getDesayuno().addAlimento(new Alimento("Plátano", 89, 1.09, 0.33, 22.84, 0.0004, 0.004, "Fruta/Verdura"));
    
        paciente.getDia1().getAlmuerzo().addAlimento(new Alimento("Arroz", 130, 2.7, 0.28, 28.17, 0.0001, 0.001, "Sano"));
        paciente.getDia1().getAlmuerzo().addAlimento(new Alimento("Pollo", 239, 27.3, 14.7, 0, 0.0001, 0.001, "Sano"));
    
        paciente.getDia1().getComida().addAlimento(new Alimento("Pasta", 131, 5.47, 0.54, 25.77, 0.0001, 0.001, "Sano"));
        paciente.getDia1().getComida().addAlimento(new Alimento("Carne", 250, 26.7, 15.3, 0, 0.0001, 0.001, "Sano"));
    
        paciente.getDia1().getMerienda().addAlimento(new Alimento("Leche", 42, 3.37, 1.03, 4.8, 0.0001, 0.001, "Sano"));
        paciente.getDia1().getMerienda().addAlimento(new Alimento("Galletas", 502, 6.7, 24.3, 66.7, 0.0001, 0.001, "Alto en azúcar"));
    
        paciente.getDia1().getCena().addAlimento(new Alimento("Pescado", 206, 20.5, 13.6, 0, 0.0001, 0.001, "Sano"));
    
    
        // Día 2
        paciente.getDia2().getDesayuno().addAlimento(new Alimento("Manzana", 52, 0.26, 0.17, 13.81, 0.0003, 0.003, "Fruta/Verdura"));
        paciente.getDia2().getDesayuno().addAlimento(new Alimento("Plátano", 89, 1.09, 0.33, 22.84, 0.0004, 0.004, "Fruta/Verdura"));
    
        paciente.getDia2().getAlmuerzo().addAlimento(new Alimento("Sandwich", 250, 12.5, 10.5, 25, 0.0001, 0.001, "Sano"));
        paciente.getDia2().getAlmuerzo().addAlimento(new Alimento("Zumo de Naranja", 46, 0.5, 0.1, 11.1, 0.0001, 0.001, "Alto en azúcar"));
    
        paciente.getDia2().getComida().addAlimento(new Alimento("Ensalada", 15, 1.5, 0.5, 2.5, 0.0001, 0.001, "Fruta/Verdura"));
    
        paciente.getDia2().getMerienda().addAlimento(new Alimento("Jamón Serrano", 191, 30.5, 7.5, 0, 0.0001, 0.001, "Sano"));
    
        paciente.getDia2().getCena().addAlimento(new Alimento("Pescado", 206, 20.5, 13.6, 0, 0.0001, 0.001, "Sano"));
    
    
        // Día 3
        paciente.getDia3().getDesayuno().addAlimento(new Alimento("Café", 1, 0.1, 0, 0.3, 0.0001, 0.001, "Sano"));
    
        paciente.getDia3().getComida().addAlimento(new Alimento("Pasta", 131, 5.47, 0.54, 25.77, 0.0001, 0.001, "Sano"));
    
        paciente.getDia3().getMerienda().addAlimento(new Alimento("Yogurt", 150, 8, 4, 15, 0.0002, 0.002, "Sano"));
        paciente.getDia3().getMerienda().addAlimento(new Alimento("Nueces", 196, 4, 19, 3, 0.0003, 0.003, "Grasas Saturadas"));
    
        paciente.getDia3().getCena().addAlimento(new Alimento("Sopa de Verduras", 120, 2, 1.5, 15, 0.0001, 0.001, "Fruta/Verdura"));
        paciente.getDia3().getCena().addAlimento(new Alimento("Tofu", 144, 16, 8, 2, 0.0002, 0.002, "Sano"));
    
    
        // Día 4
        paciente.getDia4().getAlmuerzo().addAlimento(new Alimento("Pasta con Salsa de Tomate", 200, 5, 2, 40, 0.0001, 0.001, "Sano"));
        paciente.getDia4().getAlmuerzo().addAlimento(new Alimento("Ensalada de Pollo", 180, 20, 10, 5, 0.0001, 0.001, "Sano"));
    
        paciente.getDia4().getComida().addAlimento(new Alimento("Ensalada", 15, 1.5, 0.5, 2.5, 0.0001, 0.001, "Fruta/Verdura"));
    
        paciente.getDia4().getMerienda().addAlimento(new Alimento("Frutas Mixtas", 120, 2, 1, 25, 0.0002, 0.002, "Fruta/Verdura"));
    
        paciente.getDia4().getCena().addAlimento(new Alimento("Salmón a la Parrilla", 250, 25, 15, 0, 0.0002, 0.002, "Sano"));
    
    
        // Día 5
        paciente.getDia5().getDesayuno().addAlimento(new Alimento("Cereal Integral", 120, 3, 1, 25, 0.0002, 0.002, "Sano"));
        paciente.getDia5().getDesayuno().addAlimento(new Alimento("Leche de Almendra", 60, 2, 1, 8, 0.0001, 0.001, "Sano"));
    
        paciente.getDia5().getComida().addAlimento(new Alimento("Hamburguesa de Pavo", 300, 30, 15, 0, 0.0002, 0.002, "Sano"));
        paciente.getDia5().getComida().addAlimento(new Alimento("Quinoa", 150, 5, 2, 25, 0.0002, 0.002, "Sano"));
    
        paciente.getDia5().getCena().addAlimento(new Alimento("Ensalada de Atún", 180, 15, 8, 5, 0.0001, 0.001, "Fruta/Verdura"));
        paciente.getDia5().getCena().addAlimento(new Alimento("Batata Asada", 120, 2, 0.5, 26, 0.0001, 0.001, "Fruta/Verdura"));
    }

    public void soloAltoEnAzucar(Paciente paciente){
        paciente.getDia1().getDesayuno().addAlimento(new Alimento("Galletas", 502, 6.7, 24.3, 66.7, 0.0001, 0.001, "Alto en azúcar"));
        paciente.getDia1().getAlmuerzo().addAlimento(new Alimento("Zumo de Naranja", 46, 0.5, 0.1, 11.1, 0.0001, 0.001, "Alto en azúcar"));
        paciente.getDia2().getAlmuerzo().addAlimento(new Alimento("Zumo de Fruta", 46, 0.5, 0.1, 11.1, 0.0001, 0.001, "Alto en azúcar"));
        paciente.getDia2().getMerienda().addAlimento(new Alimento("Galletas", 502, 6.7, 24.3, 66.7, 0.0001, 0.001, "Alto en azúcar"));
        paciente.getDia3().getMerienda().addAlimento(new Alimento("Galletas", 502, 6.7, 24.3, 66.7, 0.0001, 0.001, "Alto en azúcar"));
        paciente.getDia4().getMerienda().addAlimento(new Alimento("Galletas", 502, 6.7, 24.3, 66.7, 0.0001, 0.001, "Alto en azúcar"));
        paciente.getDia5().getDesayuno().addAlimento(new Alimento("Galletas", 502, 6.7, 24.3, 66.7, 0.0001, 0.001, "Alto en azúcar"));

    }

}
