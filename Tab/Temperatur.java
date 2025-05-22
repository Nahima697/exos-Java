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
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    public static double lowerValue(double[] tab) {
        double min = tab[0];

        for(double n : tab) {
            if(n < min) {
                min= n;
            }
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
    
        return tempTab;
    }
    
    public static void main(String[] args) {
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
    }
    
     
}
