public class Ingesta {
  private TipoIngesta tipo;
  private Lista<Alimento> alimentos;

  public Ingesta(TipoIngesta tipo) {
    this.tipo = tipo;
    this.alimentos = new Lista<>();
  }

  public void setTipo(TipoIngesta tipo) {
    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo.getTipo();
  }

  public void agregarAlimento(String alimento) {
    this.alimentos.add(new Alimento(alimento));
  }

  public Alimento obtenerAlimento(int indice) {
    return alimentos.get(indice);
  }

  public String listarAlimentos() {
    String response = "";
    for (int i = 0; i < alimentos.size(); i++) {
      response += "\n- " + alimentos.get(i).getNombre();
    }
    return response;
  }
}