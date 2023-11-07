
import java.util.Random;

public class CCCF {
  public static void main(String[] args) {
    // Crear una instancia de la clase Schedule con horario de trabajo de 8:00 a.m. a 8:00 p.m.
    Schedule schedule = new Schedule(8, 20);

    // Crear una instancia de la clase Time para controlar el tiempo de la simulación.
    Time time = new Time(8, 0);

    // Crear una instancia de la clase Queue para representar la cola de clientes del supermercado.
    Queue queue = new Queue();

    // Bucle principal de la simulación
    while (time.getHour() < 20) {
      // Verificar si es hora del descanso de 1:00 p.m. a 3:00 p.m.
      if (time.getHour() == 13) {
        System.out.println("Descanso de 1:00 p.m. a 3:00 p.m.");
        time.pauseSimulation(2, 0); // Pausar la simulación por 2 horas
      } else {
        // Generar nuevos clientes y agregarlos a la cola de clientes
        Random random = new Random();
        int numClients = random.nextInt(5) + 1; // Generar entre 1 y 5 clientes
        for (int i = 0; i < numClients; i++) {
          Client client = new Client(time.getHour(), time.getMinute());
          queue.addClient(client);
        }

        // Procesar a los clientes en la cola y actualizar el estado del supermercado
        schedule.update(queue);

        // Avanzar el tiempo de la simulación
        time.advanceTime(0, 10); // Avanzar 10 minutos
      }
    }
  }
}
