package lab03;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    private static Map<Character, Integer> map;

    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static int convert(String s) {
        int convertedNumber = 0;
        int countidentical = 0;


        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                throw new IllegalArgumentException();
            }

            int currentNumber = map.get(s.charAt(i));
            countidentical++;
            int next = i + 1 < s.length() ? map.get(s.charAt(i + 1)) : 0;
            int third = i + 2 < s.length() ? map.get(s.charAt(i + 2)) : 0;

            if(currentNumber == next){
                countidentical++;
            }else if(i != s.length()){
                countidentical = 0;
            }
            if(countidentical > 3){
                throw new IllegalArgumentException();
            }
            if (currentNumber >= next) {
                if(next < currentNumber && next < third){
                    throw new IllegalArgumentException();
                }
                convertedNumber += currentNumber;

            } else {
                convertedNumber -= currentNumber;
            }
        }
        if(map.containsValue(convertedNumber) && map.get(s.charAt(0)) != convertedNumber){
            throw new IllegalArgumentException();
        }
        return convertedNumber;
    }
}
