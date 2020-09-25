package ua.kpi.barber;

public class Barber extends Thread {

  Barbershop barbershop;

  public Barber(Barbershop barbershop) {
    this.barbershop = barbershop;
  }

  public void run(){
    while (true){
      while( barbershop.queueSize.get() == 0) {
        synchronized (barbershop.barberSynchronization){
          try {
            barbershop.barberSynchronization.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
      synchronized (barbershop.clients){
        barbershop.queueSize.decrementAndGet();

        Client client = barbershop.clients.poll();
        synchronized (client){
          client.notify();
        }
        try {
          System.out.println("Barber:Haircut for client is started");
          Thread.sleep(barbershop.CLIENT_SERVICE_TIME);
          System.out.println("Barber:Haircut for client is finished");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (client){
          client.notify();
        }
      }
    }
  }


}
