package Collection.Exo2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ClientQueueManager {

    public Queue<String>  clientsQueue = new LinkedList<>();

    public void enqueueClient(String name) {
        clientsQueue.offer(name);
    
    }

    public void dequeueClient() {

        clientsQueue.poll();

    }

    public Queue<String> showClientsQueue() {
        return clientsQueue;
    }

    public static void main(String[] args) {
        ClientQueueManager clientManager = new ClientQueueManager();
         Scanner scanner = new Scanner(System.in);
         System.out.println("Veuillez saisir le nom des clients dans la file (tapez 'fin' pour terminer) :");
         String client;

         while (true) {
             System.out.print("> ");
             client = scanner.nextLine();
             if (client.equalsIgnoreCase("fin")) {
                 break;
             }
             clientManager.enqueueClient(client);
         }
         System.out.println("\nListe des tâches :");
         int i = 1;
         for (String remainingClient : clientManager.showClientsQueue()) {
             System.out.println("Client " + i + ": " + remainingClient);
             i++;
         }

         System.out.println("\nSuppression du premier client de la file...");
         clientManager.dequeueClient(); 
         System.out.println("\nListe finale des tâches :");
         int j = 1;
         for (String remainingClient2 : clientManager.showClientsQueue()) {
             System.out.println("Client " + j + ": " + remainingClient2);
             j++;
         }
         scanner.close();

        }
    
}
