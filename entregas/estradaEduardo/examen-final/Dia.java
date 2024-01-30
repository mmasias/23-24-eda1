class Dia {
  private int dia;
  private Lista<Ingesta> ingestas;

  public Dia(int numero) {
    this.dia = numero;
    this.ingestas = new Lista<>();
    for (TipoIngesta tipo : TipoIngesta.values()) {
      this.agregarIngesta(new Ingesta(tipo));
    } 
  }

  public int getDia() {
    return dia;
  }

  public void setDia(int dia) {
    this.dia = dia;
  }

  public void agregarIngesta(Ingesta ingesta) {
    ingestas.add(ingesta);
  }

  public Ingesta obtenerIngesta(int indice) {
    return ingestas.get(indice);
  }


  public void listarIngestas() {
    for (int i = 0; i < ingestas.size(); i++) {
      System.out.println(ingestas.get(i).getTipo() + ": " + ingestas.get(i).listarAlimentos());
    }
  }

}