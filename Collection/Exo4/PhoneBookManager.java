package Collection.Exo4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBookManager {

    private Map<String, Integer> phones = new HashMap<>();

    public void addContact(String name, Integer phoneNumber) {
        phones.put(name, phoneNumber);
    }

    public Integer searchByName(String name) {
        return phones.get(name);
    }

    public String searchByNumber(Integer number) {
        for (Map.Entry<String, Integer> entry : phones.entrySet()) {
            if (entry.getValue().equals(number)) {
                return entry.getKey();
            }
        }
        return null;
    }
    

    public void showContacts() {
        if (phones.isEmpty()) {
            System.out.println("Le carnet de contacts est vide.");
        } else {
            System.out.println("Liste des contacts :");
            for (Map.Entry<String, Integer> entry : phones.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        PhoneBookManager manager = new PhoneBookManager();
        Scanner scanner = new Scanner(System.in);
        String choix;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Ajouter un contact");
            System.out.println("2. Rechercher par nom");
            System.out.println("3. Rechercher par numéro");
            System.out.println("4. Afficher tous les contacts");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    System.out.print("Nom du contact : ");
                    String nom = scanner.nextLine();
                    System.out.print("Numéro de téléphone : ");
                    int numero = Integer.parseInt(scanner.nextLine());
                    manager.addContact(nom, numero);
                    System.out.println("Contact ajouté !");
                    break;

                case "2":
                    System.out.print("Nom à rechercher : ");
                    String searchNom = scanner.nextLine();
                    Integer resultNum = manager.searchByName(searchNom);
                    if (resultNum != null) {
                        System.out.println("Numéro trouvé : " + resultNum);
                    } else {
                        System.out.println("Aucun contact trouvé avec ce nom.");
                    }
                    break;

                case "3":
                    System.out.print("Numéro à rechercher : ");
                    int searchNum = Integer.parseInt(scanner.nextLine());
                    String resultNom = manager.searchByNumber(searchNum);
                    if (resultNom != null) {
                        System.out.println("Nom trouvé : " + resultNom);
                    } else {
                        System.out.println("Aucun contact trouvé avec ce numéro.");
                    }
                    break;

                case "4":
                    manager.showContacts();
                    break;

                case "5":
                    System.out.println("Fin du programme.");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (!choix.equals("5"));

        scanner.close();
    }
}
