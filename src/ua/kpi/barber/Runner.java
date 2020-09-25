package ua.kpi.barber;

public class Runner {

  public static void main(String[] args) {
    Barbershop barbershop = new Barbershop();
    Barber barber = new Barber(barbershop);
    barber.start();
    while (true){
      Client client = new Client(barbershop);
      client.start();
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}
