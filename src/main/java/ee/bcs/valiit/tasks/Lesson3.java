package ee.bcs.valiit.tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class Lesson3 {
    public static void main(String[] args) {
        // exercise1(5);
//        System.out.println(factorial(5));
//        System.out.println(reverseString("Tagurpidi"));
//        System.out.println(isPrime(7));
//        System.out.println(Arrays.toString(sort(new int[]{6, 2, 7, 3, 1})));
//        System.out.println(evenFibonacci(20));
        System.out.println(morseCode("hello"));
    }


    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        int fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;

//            x = 5 * x-i(4)+ x-i(4)+ x-i(3).....

//            int sumArv = x[0];
//            for (int i = 1; i < x.length; i++) {
//                sumArv += x[i];
            // System.out.println(factoriaal);
        }
        System.out.println(fact);

        return fact;
    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {
        String tagurpidi = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            tagurpidi = tagurpidi + a.charAt(i);
        }
        System.out.println(tagurpidi);
        return tagurpidi;
    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {
        boolean primaar = false;
        if (x == 2) {
            primaar = true;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                primaar = false;
                break;
            }
            if (x / i == 1) {
                primaar = true;
            }
        }
        System.out.println(primaar);
        return primaar;
    }
//        boolean primaar = false;
//        int primaariksSaamine = x / 2;
//        for (int i = 2; i <= primaariksSaamine; i++){
//            if (x % i == 0) {
//                primaar = false;
//                break;
//            } else {
//                primaar = true;
//                break;
//            }
//        }


    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {
        int[] suurus = a;
        int algseltNumber = 0;
        System.out.println("Prindin välja algse array ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(suurus[i] + " ");
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    algseltNumber = suurus[i];
                    suurus[i] = suurus[j];
                    suurus[j] = algseltNumber;
                }
            }
        }
        System.out.println("\nPrindin välja muudetud array ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(suurus[i]);
        }
        return suurus;
    }

    //    int kuiSuurArray = inputArray.length;
//    int[] arvud = new int[kuiSuurArray];
//        for (int i = kuiSuurArray; i > 0; i--) {
//        arvud[i-1] = inputArray[kuiSuurArray-i];
//    }
//        System.out.println(Arrays.toString(arvud));
//        return arvud;
    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        if (x == 0) {
            return 0;
        }
        int arv = x;
        int a = 0;
        int b = 1;
        int kokku = 0;
        for (int i = 2; i <= x; i++) {
            int algarv = a + b;
            a = b;
            b = algarv;
            if (algarv >= arv) {
                break;
            }
            if (b % 2 == 0) {
                kokku = kokku + b;

            }
        }
        System.out.println(kokku);
        return kokku;
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
        Map<Character, String> morse = new HashMap<>();
        String kuhuMorse = "";
        for (int i = 0; i < text.length(); i++) {
            morse.put('s', "...");
            morse.put('o', "---");
            morse.put('h', "....");
            morse.put('l', ".-..");
            morse.put('e', ".");
            kuhuMorse += (morse.get(text.charAt(i)) + " ");
        }

        System.out.println(kuhuMorse.trim());
        return kuhuMorse.trim();
    }
}
