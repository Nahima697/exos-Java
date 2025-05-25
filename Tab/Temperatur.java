package Tab;

import java.util.Scanner;

public class Temperatur {
   
     public static void afficher (double[] tempTab) {
        for (double val : tempTab) System.out.print(val + " ");
        System.out.println();
    }

    public static int somme(double[] tab) {
        int total = 0;
        for (double n : tab) total += n;
        return total;
    }
    
    public static double moyenne(double[] tab) {
        return (double) somme(tab) / tab.length;
    }

    public static double higherValue(double[] tab){
        double max = tab[0];
        for (double n:tab) {
            max = (n > max) ? n : max;
          
        }
        return max;
    }

    public static double lowerValue(double[] tab) {
        double min = tab[0];

        for (double n : tab) {
            min = (n < min) ? n : min;
        }
        
        return (double) min;
    }

    public static String[] higherThanFifteen(double[] tab) {
        String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};

        int count = 0;
        for (double temp : tab) {
            if (temp > 15) {
                count++;
            }
        }

        String[] daysUp15 = new String[count];
        int index = 0;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > 15) {
                daysUp15[index] = jours[i];
                index++;
            }
        }
        return daysUp15;
    }

    
    public static double[] saisirTempératures() {
        Scanner scanner = new Scanner(System.in);
        String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        double[] tempTab = new double[7];
        System.out.println("Veuillez saisir les températures pour chaque jour de la semaine :");
        for (int i = 0; i < 7; i++) {
            System.out.print(jours[i] + " : ");
            tempTab[i] = scanner.nextDouble();
        }
        scanner.close();
        return tempTab;
    }

    public static double[] convertToFahrenheit(double [] celcius) {
         double[] fahrenheit = new double[celcius.length];
         int index = 0;

         for(int i = 0; i < celcius.length; i++) {    
            fahrenheit[index]= celcius[i]* 9/5 + 32;
            index++;        
         }
         return fahrenheit;
    }

    
    public static void main(String[] args) {

        System.out.println("=== TEST ===");
        //Test de la méthode moyenne
        double[] test1 = {10.0, 15.0, 20.0};
        double attendu1 = 15.0;
        double obtenu1 = moyenne(test1);
        System.out.println("Test moyenne : " + (attendu1 == obtenu1 ? "True" : "False"));
        
        // Test de la méthode higherValue
        double[] test2 = {8.0, 25.0, 12.0};
        double attendu2 = 25.0;
        double obtenu2 = higherValue(test2);
        System.out.println("Test valeur max : " + (attendu2 == obtenu2 ? "True" : "False"));
        
        // Test de la méthode lowerValue
        double[] test3 = {8.0, 25.0, 2.0};
        double attendu3 = 2.0;
        double obtenu3 = lowerValue(test3);
        System.out.println("Test valeur min : " + (attendu3 == obtenu3 ? "True" : "False"));
        
        // Test de la méthode convertToFahrenheit
        double[] test4 = {0.0, 100.0};
        double[] attendu4 = {32.0, 212.0};
        double[] obtenu4 = convertToFahrenheit(test4);
        boolean testFahrenheit = attendu4[0] == obtenu4[0] && attendu4[1] == obtenu4[1];
        System.out.println("Test conversion Fahrenheit : " + (testFahrenheit ? "True" : "FALSE"));
        
        // Test de la méthode higherThanFifteen
        double[] test5 = {10.0, 16.0, 14.0, 17.0, 12.0, 20.0, 13.0}; // Lundi à Dimanche
        String[] attendu5 = {"Mardi", "Jeudi", "Samedi"};
        String[] obtenu5 = higherThanFifteen(test5);
        boolean testJours = attendu5.length == obtenu5.length;
        for (int i = 0; i < attendu5.length && testJours; i++) {
            if (!attendu5[i].equals(obtenu5[i])) {
                testJours = false;
            }
        }
        System.out.println("Test jours > 15°C : " + (testJours ? "True" : "False"));
        
        System.out.println("==========================\n");
        double[] tempTab = saisirTempératures(); 
        afficher(tempTab);
        System.out.println("Moyenne : " + moyenne(tempTab));
        System.out.println("Plus haute température : " + higherValue(tempTab));
        System.out.println("Plus basse température : " + lowerValue(tempTab));
    
        String[] joursSup15 = higherThanFifteen(tempTab);
        System.out.println("Jours où la température dépasse 15°C : ");
        for (String jour : joursSup15) {
            System.out.println(jour);
        }

        double[] fahrenheitTemp = convertToFahrenheit(tempTab);

        System.out.println("Températures en fahrenheit: ");
        for (double temp : fahrenheitTemp) {
            System.out.println(temp);
        }
    }
    
     
}
