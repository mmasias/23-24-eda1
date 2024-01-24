public class Dias {
    private int diaIndex;
    private List<IngestaTipo> ingestasList;

    public Dias(int diaIndex) {
        this.diaIndex = diaIndex;
        this.ingestasList = new List<>();
        for (String tipoIngesta : getTiposIngestaValidos()) {
            ingestasList.add(new IngestaTipo(tipoIngesta, new Ingestas()));
        }
    }

    public void agregarAlimento(Alimentos alimento, String tipoIngesta) {
        IngestaTipo ingestaTipo = obtenerIngestaTipo(tipoIngesta);
        if (ingestaTipo != null) {
            ingestaTipo.getIngestas().agregarAlimento(alimento);
        } else {
            System.out.println("Error: Tipo de ingesta no válido.");
        }
    }

    public int getDiaIndex() {
        return diaIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append("Día ").append(diaIndex).append(":\n");

        for (int i = 0; i < ingestasList.size(); i++) {
            IngestaTipo ingestaTipo = ingestasList.get(i);
            sb.append(" ").append(ingestaTipo.toString());
        }

        return sb.toString();
    }

    private static String[] getTiposIngestaValidos() {
        return new String[]{"Desayuno", "Media Mañana", "Almuerzo", "Merienda", "Cena"};
    }
}
