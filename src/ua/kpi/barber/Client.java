package ua.kpi.barber;

public class Client extends Thread {

  Barbershop barbershop;

  public Client(Barbershop barbershop) {
    this.barbershop = barbershop;
  }

  public void run(){
    int currentSize;
    do{
      currentSize = barbershop.queueSize.get();
      if( currentSize >= barbershop.MAX_QUEUE_SIZE){
        return;
      }
    }while(!barbershop.queueSize.compareAndSet(currentSize, currentSize +1 ));
    synchronized (barbershop.clients){
      barbershop.clients.add(this);
    }
    synchronized (barbershop.barberSynchronization){
      barbershop.barberSynchronization.notify();
    }
    synchronized (this){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Client:Haircut is started");
    }

    synchronized (this){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Client:Haircut is finished");
    }

  }

}
