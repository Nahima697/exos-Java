

import Exo1.Exo1;
import Exo2.Exo2;
import Exo4.Exo4;
import Exo5.Exo5;
import Exo6.Exo6;
import Exo7.Exo7;

public class App {
    public static void main(String[] args) {

        Exo1 exo1 = new Exo1(); 

        System.out.println("4 est pair ? " + exo1.estPair(4));
        System.out.println("7 est pair ? " + exo1.estPair(7));

        Exo2 exo2 = new Exo2();

        System.out.println("Addition:  "+ exo2.sum(15,5));
        System.out.println("Soustraction:  "+ exo2.substract(15,5));
        System.out.println("Multiplication :  "+ exo2.multiply(5,15));
        System.out.println("Division :  "+ exo2.divide(15,5));


        Exo4 exo4 = new Exo4();

        int[] tab = {3, 7, 2, 9, 5};

        System.out.println("Le max est : " + exo4.max(tab));

        System.out.println("Le max est : " + exo4.max2(3, 7, 2, 9, 5));

        Exo5 exo5 = new Exo5();
        System.out.println(exo5.upsideDown("bonjour"));

        Exo6 exo6 = new Exo6(); 
        
        int[] tableau = {5, 12, 8, 15, 3, 22, 9};
        int[] resultats = exo6.greaterThanTen(tableau);

        System.out.print("Valeurs > 10 : ");
        for (int valeur : resultats) {
            System.out.print(valeur + " ");
        }

        Exo7 exo7 = new Exo7(); 

        System.out.println("Triangle d'étoile: " + exo7.triangleStar());
      
    }
}
