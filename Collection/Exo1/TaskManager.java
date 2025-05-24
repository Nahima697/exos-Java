package Collection.Exo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    public List<String> tasks = new ArrayList<>();
    
    public void addTask(String task) {
        tasks.add(task);
    }

    public void showTasks() {
         System.out.println("Parcours de la liste :");
        for (String task : tasks) {
            System.out.println("- " + task);
        }
    }

    public void deleteTasks(int index){
        tasks.remove(index);
    
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer vos tâches (tapez 'fin' pour terminer) :");
        String task;

        while (true) {
            System.out.print("> ");
            task = scanner.nextLine();
            if (task.equalsIgnoreCase("fin")) {
                break;
            }
            manager.addTask(task);
        }

        System.out.println("\nListe finale des tâches :");
        for (int i = 0; i < manager.tasks.size(); i++) {
            System.out.println(i + " - " + manager.tasks.get(i));
        }

        System.out.println("\nNotez l'indice de la tâche à supprimer :");
        int index = scanner.nextInt();
        scanner.nextLine(); 

        if (index >= 0 && index < manager.tasks.size()) {
            String deletedTask = manager.tasks.get(index); 
            manager.deleteTasks(index);
            System.out.println("Tâche supprimée : " + deletedTask);
        } else {
            System.out.println("Indice invalide.");
        }

        System.out.println("\nListe mise à jour des tâches :");
        manager.showTasks();
        
        scanner.close();
    }
}
