package TP.EventRegistration;

import java.util.*;

public class EventRegistration {

    private List<String> arrivalOrder = new ArrayList<>();
    private Map<String, String> participantMap = new HashMap<>();
    private int idCounter = 1;

    public void addParticipant(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        String participantId = lastName.toUpperCase() + "-" + String.format("%03d", idCounter++);
        arrivalOrder.add(participantId);
        participantMap.put(participantId, fullName);
    }

    public void displayOrderedParticipants() {
        System.out.println("\n📋 List of Participants:");
        for (String id : arrivalOrder) {
            System.out.println(id + " → " + participantMap.get(id));
        }
    }

    public void searchParticipant(String id) {
        String normalizedId = id.toUpperCase();
        if (participantMap.containsKey(normalizedId)) {
            System.out.println("Partiipant trouvé " + participantMap.get(normalizedId));
        } else {
            System.out.println("Aucun participant avec cet identifiant: " + id);
        }
    }

    public void displayTotalParticipants() {
        System.out.println("\n Nombre total de participants: " + participantMap.size());
    }

    public static void main(String[] args) {
        EventRegistration registration = new EventRegistration();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans notre espace d'inscription");

        boolean keepGoing = true;
        while (keepGoing) {
            System.out.print("\n Prénom: ");
            String firstName = scanner.nextLine().trim();

            System.out.print("Nom: ");
            String lastName = scanner.nextLine().trim();

            registration.addParticipant(firstName, lastName);

            System.out.print("Unn autre participant? (o/n): ");
            String response = scanner.nextLine().trim();
            keepGoing = response.equalsIgnoreCase("o");
        }

        registration.displayOrderedParticipants();
        registration.displayTotalParticipants();

        System.out.print("\n Trouver un participant avec son identifiant (exem, TOUMI-001): ");
        String searchId = scanner.nextLine().trim();
        registration.searchParticipant(searchId);

        scanner.close();
    }
}
