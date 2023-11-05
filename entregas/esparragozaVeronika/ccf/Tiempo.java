package ccf;
public class Tiempo {
    int hora;
    int minuto;
    public Tiempo(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }
    public int getHora(){
        return hora;
    }
    public int getMinuto(){
        return minuto;
    }
    public void subeTiempo(){
        if (minuto == 59) {
            minuto = 0;
            hora += 1;
        }
        if (hora == 24) {
            minuto = 0;
            hora = 0;
        }
        minuto += 1;
    }
}