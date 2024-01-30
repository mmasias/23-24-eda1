package core;


public class Dia {

    private String dia;
    private Ingesta desayuno, almuerzo, comida, merienda, cena;

    public Dia(int dia) {
        this.dia = "Dia " + dia;
        this.desayuno = new Ingesta("Desayuno");
        this.almuerzo = new Ingesta("Almuerzo");
        this.comida = new Ingesta("Comida");
        this.merienda = new Ingesta("Merienda");
        this.cena = new Ingesta("Cena");
    }

    public String getDia() {
        return dia;
    }

    public Ingesta getDesayuno() {
        return desayuno;
    }

    public Ingesta getAlmuerzo() {
        return almuerzo;
    }

    public Ingesta getComida() {
        return comida;
    }

    public Ingesta getMerienda() {
        return merienda;
    }

    public Ingesta getCena() {
        return cena;
    }

    public double getCalorias() {
        double caloriasTotal = this.desayuno.getCalorias() + this.almuerzo.getCalorias() + this.comida.getCalorias() + this.merienda.getCalorias() + this.cena.getCalorias();
        return caloriasTotal;
    }
    
    public double getProteinas() {
        double proteinasTotal = this.desayuno.getProteinas() + this.almuerzo.getProteinas() + this.comida.getProteinas() + this.merienda.getProteinas() + this.cena.getProteinas();
        return proteinasTotal;
    }

    public double getGrasas() {
        double grasasTotal = this.desayuno.getGrasas() + this.almuerzo.getGrasas() + this.comida.getGrasas() + this.merienda.getGrasas() + this.cena.getGrasas();
        return grasasTotal;
    }

    public double getCarbohidratos() {
        double carbohidratosTotal = this.desayuno.getCarbohidratos() + this.almuerzo.getCarbohidratos() + this.comida.getCarbohidratos() + this.merienda.getCarbohidratos() + this.cena.getCarbohidratos();
        return carbohidratosTotal;
    }

    public double getVitaminas() {
        double vitaminasTotal = this.desayuno.getVitaminas() + this.almuerzo.getVitaminas() + this.comida.getVitaminas() + this.merienda.getVitaminas() + this.cena.getVitaminas();
        return vitaminasTotal;
    }

    public double getMinerales() {
        double mineralesTotal = this.desayuno.getMinerales() + this.almuerzo.getMinerales() + this.comida.getMinerales() + this.merienda.getMinerales() + this.cena.getMinerales();
        return mineralesTotal;
    }

    public String extraerTipos() {
        int contadorFrutaVerdura = 0;
        int contadorAltoEnAzucar = 0;
        int contadorGrasasSaturadas = 0;
        int contadorSano = 0;
        String resultadoMayoritario = "";
    
        if (this.getDesayuno().extraerTipos().equals("Fruta/Verdura")) {
            contadorFrutaVerdura++;
        } else if (this.getDesayuno().extraerTipos().equals("Alto en azúcar")) {
            contadorAltoEnAzucar++;
        } else if (this.getDesayuno().extraerTipos().equals("Grasas Saturadas")) {
            contadorGrasasSaturadas++;
        } else if (this.getDesayuno().extraerTipos().equals("Sano")) {
            contadorSano++;
        }
    
        if (this.getAlmuerzo().extraerTipos().equals("Fruta/Verdura")) {
            contadorFrutaVerdura++;
        } else if (this.getAlmuerzo().extraerTipos().equals("Alto en azúcar")) {
            contadorAltoEnAzucar++;
        } else if (this.getAlmuerzo().extraerTipos().equals("Grasas Saturadas")) {
            contadorGrasasSaturadas++;
        } else if (this.getAlmuerzo().extraerTipos().equals("Sano")) {
            contadorSano++;
        }
    
        if (this.getComida().extraerTipos().equals("Fruta/Verdura")) {
            contadorFrutaVerdura++;
        } else if (this.getComida().extraerTipos().equals("Alto en azúcar")) {
            contadorAltoEnAzucar++;
        } else if (this.getComida().extraerTipos().equals("Grasas Saturadas")) {
            contadorGrasasSaturadas++;
        } else if (this.getComida().extraerTipos().equals("Sano")) {
            contadorSano++;
        }
    
        if (this.getMerienda().extraerTipos().equals("Fruta/Verdura")) {
            contadorFrutaVerdura++;
        } else if (this.getMerienda().extraerTipos().equals("Alto en azúcar")) {
            contadorAltoEnAzucar++;
        } else if (this.getMerienda().extraerTipos().equals("Grasas Saturadas")) {
            contadorGrasasSaturadas++;
        } else if (this.getMerienda().extraerTipos().equals("Sano")) {
            contadorSano++;
        }
    
        if (this.getCena().extraerTipos().equals("Fruta/Verdura")) {
            contadorFrutaVerdura++;
        } else if (this.getCena().extraerTipos().equals("Alto en azúcar")) {
            contadorAltoEnAzucar++;
        } else if (this.getCena().extraerTipos().equals("Grasas Saturadas")) {
            contadorGrasasSaturadas++;
        } else if (this.getCena().extraerTipos().equals("Sano")) {
            contadorSano++;
        }
    
        if (contadorFrutaVerdura > contadorAltoEnAzucar && contadorFrutaVerdura > contadorGrasasSaturadas && contadorFrutaVerdura > contadorSano) {
            resultadoMayoritario = "Fruta/Verdura";
        } else if (contadorAltoEnAzucar > contadorFrutaVerdura && contadorAltoEnAzucar > contadorGrasasSaturadas && contadorAltoEnAzucar > contadorSano) {
            resultadoMayoritario = "Alto en azúcar";
        } else if (contadorGrasasSaturadas > contadorFrutaVerdura && contadorGrasasSaturadas > contadorAltoEnAzucar && contadorGrasasSaturadas > contadorSano) {
            resultadoMayoritario = "Grasas Saturadas";
        } else if (contadorSano > contadorFrutaVerdura && contadorSano > contadorAltoEnAzucar && contadorSano > contadorGrasasSaturadas) {
            resultadoMayoritario = "Sano";
        }
    
        return resultadoMayoritario;
    }
    
}
