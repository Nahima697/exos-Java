package Exo4;

import java.util.ArrayList;
import java.util.Collections;

public class Exo4 {
    public int max(int[] numbers) {

        ArrayList<Integer> tab = new ArrayList<Integer>();

        for ( int number:numbers) {
            tab.add(number);
        }
        return Collections.max(tab);     
    }

    public int max2(int... numbers) {
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
