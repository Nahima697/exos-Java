package IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class StudentApp {

    public static double averageNotes(double[] notes) {
        double sum = 0;
        for (double note : notes) sum += note;
        return sum / notes.length;
    }

    public static void writeReportCard(List<String> content, String name) {
        try {
            Files.write(Paths.get("bulletin_" + name + ".txt"), content);
            System.out.println("Bulletin sauvegardé dans bulletin_" + name + ".txt");
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Double> bulletin = new LinkedHashMap<>();

        System.out.print("Entrez votre prénom : ");
        String name = sc.nextLine();

        double[] notes = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Entrez le nom de la matière " + (i + 1 )+" : ");
            String matiere = sc.nextLine();

            System.out.print("Note obtenue en" + matiere +"(sur 20)  : ");
            double note = sc.nextDouble();
            sc.nextLine(); 
            bulletin.put(matiere, note);
            notes[i] = note;
        }

        System.out.println("\nBulletin de " + name + " :");
        for (Map.Entry<String, Double> entry : bulletin.entrySet()) {
            System.out.println("- " + entry.getKey() + " : " + entry.getValue()+"/20");
        }

        double moyenne = averageNotes(notes);
        System.out.printf("Votre Moyenne Générale est de : %.2f\n", moyenne + "/20");

       
        List<String> lines = new ArrayList<>();
        lines.add("Nom :  " + name);
        lines.add("Date: "+  LocalDate.now());
        for (Map.Entry<String, Double> entry : bulletin.entrySet()) {
            lines.add(entry.getKey() + " : " + entry.getValue()+"/20");
        }
        lines.add(String.format("Moyenne Générale : %.2f", moyenne));

        writeReportCard(lines, name);

        sc.close();
    }
}
