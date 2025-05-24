package Collection.Exo3;

import java.util.Scanner;
import java.util.TreeSet;

public class SortFirstNameManager {
    TreeSet<String> firstNameList = new TreeSet<>();

    public void addFirstName(String firstName) {
        firstNameList.add(firstName);
    }
    
    public TreeSet<String> showSortFirstName(TreeSet<String> firstNameList) {
        return firstNameList;

    }

    public void main(String [] args) {
        SortFirstNameManager sortFirstNameManager = new SortFirstNameManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir les prénoms (tapez 'fin' pour terminer) :");
        String firstName;
        while (true) {
            System.out.print("> ");
            firstName = scanner.nextLine();
            sortFirstNameManager.addFirstName(firstName);
            if (firstName.equalsIgnoreCase("fin")) {
                break;
            }
     
            System.out.println("\nListe des prénoms triées:");
            int i = 1;
            for (String sortFirstName: sortFirstNameManager.showSortFirstName(firstNameList)) {
                System.out.println("Client " + i + ": " + sortFirstName);
                i++;
            }
        }
        scanner.close();
    }
}
