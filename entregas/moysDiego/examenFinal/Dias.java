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
        for (int i = 0; i < ingestasList.size(); i++) {
            IngestaTipo ingestaTipo = ingestasList.get(i);
            if (ingestaTipo.getTipo().equals(tipoIngesta)) {
                ingestaTipo.getIngestas().agregarAlimento(alimento);
                return;
            } else {
                System.out.println("Error: Tipo de ingesta no válido.");
            }
        }
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
