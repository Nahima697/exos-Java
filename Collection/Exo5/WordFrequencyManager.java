package Collection.Exo5;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.Scanner;

public class WordFrequencyManager {
    private Map<String, Integer> paragraph = new HashMap<>();
    private TreeSet<String> sortedWords;

    // Méthode pour remplir la Map avec la fréquence des mots
    public void countWordFrequency(String text) {
        String[] words = text.split("\\W+");
        for (String word : words) {
            word = word.toLowerCase();
            paragraph.put(word, paragraph.getOrDefault(word, 0) + 1);
        }
        // Mettre à jour sortedWords après avoir compté les mots
        sortedWords = new TreeSet<>(paragraph.keySet());
    }

    // Getter pour accéder à la map des mots et fréquences
    public Map<String, Integer> readParagraph() {
        return paragraph;
    }

    // Affiche les mots triés et leurs fréquences
    public void sortWords() {
        for (String mot : sortedWords) {
            System.out.println(mot + " : " + paragraph.get(mot));
        }
    }

    // Méthode main pour lancer le programme
    public static void main(String[] args) {
        WordFrequencyManager manager = new WordFrequencyManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez un paragraphe :");
        String input = scanner.nextLine();

        manager.countWordFrequency(input);
        manager.sortWords();

        scanner.close();
    }
}
