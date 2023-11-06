import java.util.Calendar;
import java.util.Date;

public class CentroComercial {
    private Supermercado carrefour;
    private Date date;

    public CentroComercial () {
        carrefour = new Supermercado();
        date = getTodayAt9AM();
    }

    public void run() {
        while (true){
            eventsInOneMinute();
            date = addOneMinute(date);
            try {
                Thread.sleep(200); // a modificar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (date.getHours() == 21 && date.getMinutes() == 0){
                break;
            }
        }
    }

    private Date getTodayAt9AM() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private Date addOneMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, 1);
        return calendar.getTime();
    }

    private void eventsInOneMinute(){
        carrefour.manageClientLine();
        carrefour.generateNewClient();
        showLog();
        carrefour.cashItems();
    }

    ///////// DISPLAY PART  //////////

    public void showLog(){
        System.out.print("Hora: " + this.date);
        System.out.print(" - ");
        carrefour.showClientInLastMinute();
        System.out.print(" - ");
        carrefour.showClientLine();
        carrefour.showCashRegisters();
        System.out.println("- ".repeat(20));
    }
}
