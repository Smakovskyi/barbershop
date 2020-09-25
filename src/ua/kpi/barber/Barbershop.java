package ua.kpi.barber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Barbershop {
  public final int MAX_QUEUE_SIZE = 5;
  public final int CLIENT_SERVICE_TIME = 100;
  public AtomicInteger queueSize = new AtomicInteger();
  Object barberSynchronization = new Object();
  Queue<Client> clients = new LinkedList<>();
}
