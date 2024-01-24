package ExamenFinal;

public class Encuesta {
    private List<Dias> diasList;

    public Encuesta() {
        this.diasList = new List<>();
        for (int i = 1; i <= 5; i++) {
            diasList.add(new Dias(i));
        }
    }

    public void agregarAlimento(Alimentos alimento, int dia, String tipoIngesta) {
        if (dia >= 1 && dia <= diasList.size()) {
            Dias diaObj = diasList.get(dia - 1);
            diaObj.agregarAlimento(alimento, tipoIngesta);
        } else {
            System.out.println("Error: Día no válido.");
        }
    }

    public void obtenerInfoDieta() {
        for (int i = 0; i < diasList.size(); i++) {
            System.out.println(diasList.get(i).toString());
        }
    }
}