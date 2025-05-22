package Exo6;

import java.util.ArrayList;

public class Exo6 {

    public int [] greaterThanTen(int [] tab) {

        ArrayList<Integer> newtab= new ArrayList<Integer>();


       for(int i = 0;i<tab.length;i++) {
        if(tab[i]> 10) {
            newtab.add(tab[i]);
        }

       }
       int[] result = new int[newtab.size()];
       for (int i = 0; i < newtab.size(); i++) {
        result[i] = newtab.get(i);
    }
    return result;
    
    }
    
}
