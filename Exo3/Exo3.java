package Exo3;

import java.util.Scanner;

public class Exo3 {
        public static int countVoyel(String mot) {
            mot = mot.toLowerCase();
            int count = 0;
            for (char c : mot.toCharArray()) {
                if ("aeiouy".indexOf(c) != -1) count++;
            }
            return count;
        }
          public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mot : ");
        String mot = scanner.nextLine();
        System.out.println("Voyelles : " + countVoyel(mot));
        scanner.close();
    }
    
    }