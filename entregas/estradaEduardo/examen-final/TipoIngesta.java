public enum TipoIngesta {
  DESAYUNO("Desayuno", 1),
  MEDIA_MANANA("Media Mañana", 2),
  ALMUERZO("Almuerzo", 3),
  MERIENDA("Merienda", 4),
  CENA("Cena", 5);

  private final String tipo;
  private final int index;

  TipoIngesta(String tipo, int index) {
    this.tipo = tipo;
    this.index = index;
  }

  public String getTipo() {
    return this.tipo;
  }

  public int getIndex(){
    return this.index;
  }
}