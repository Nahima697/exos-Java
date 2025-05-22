package Exo8;

public class Exo8 {

    public int[] exchangeValue(int[] tab, int index1, int index2) {
        if (index1 >= 0 && index1 < tab.length && index2 >= 0 && index2 < tab.length) 
        {

            int temp = tab[index1];
            tab[index1] = tab[index2];
            tab[index2] = temp;

        }
        else {
            System.out.println("Les indices sont pas bons");
        }
         return tab;

    }
    
}
