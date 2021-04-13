package ee.bcs.valiit.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        // multiplyTable(3,3);
        //System.out.println(Arrays.toString(reverseArray(new int[]{6, 2, 7, 3, 1})));
        //System.out.println(sequence3n(1, 10));
        //System.out.println(reverseArray(int[5]));
    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {
        int kuiSuurArray = inputArray.length;
        int[] arvud = new int[kuiSuurArray];
        for (int i = kuiSuurArray; i > 0; i--) {
            arvud[i - 1] = inputArray[kuiSuurArray - i];
        }
        System.out.println(Arrays.toString(arvud));
        return arvud;
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] evenNumbers(int n) {
        // int n = 5;
        int[] arv = new int[n];
        for (int i = 0; i < n; i++) {
            arv[i] = (i + 1) * 2;
        }
        return arv;
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] x) {
        int minArv = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] < minArv) {
                minArv = x[i];
            }
        }
        return minArv;
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] x) {
        int maxArv = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] > maxArv) {
                maxArv = x[i];
            }
        }
        return maxArv;
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] x) {
        int sumArv = x[0];
        for (int i = 1; i < x.length; i++) {
            sumArv += x[i];
        }
        return sumArv;
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {
        x = 3;
        y = 3;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.print(j * i + " ");
            }
            System.out.println();
        }
        return;

    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2); (((((NESTED LOOPS KASUTADA)))))
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {
        int a = 0;
        int b = 1;
        int fib = 0;

        for (int i = 0; i < n; i++) {
            a = b;
            b = fib;
            fib = (a + b);
        }
        return fib;
    }
    // 0 1 | 0 + 1 = 1
    // 1 1 | 1 + 1 = 2
    // 1 2 | 1 + 2 = 3
    // 2 3 | 2 + 3 = 5
    // 3 5 | 3 + 5 = 8
    // ja panna tsüklisse

    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 10 ja 20 puhul on vastus 20

    public static int sequence3n(int x, int y) {
        int kokku = 0;
        for (int i = x; i <= y; i++) {
            int kordused = 1;
            int algArv = i;
            while (algArv > 1) {
                if (algArv % 2 == 0) {
                    algArv = algArv / 2;
                } else {
                    algArv = (algArv * 3) + 1;
                }
                kordused++;
            }
            if (kordused > kokku) {
                kokku = kordused;
            }
        }
        System.out.println(kokku);
        return kokku;
    }
}
//    int kordused = 1;
//        while (x > 1) {
//                x = nextElement(x);
//                kordused++;
//                }
//                return kordused;
//        if (x % 2 == 0) {
//                x = x / 2;
//                } else {
//                x = (x * 3) + 1;
//                }
//                return x;
//int algArv = 0;
//        for (int i = x; i < y; i++) {
//        int kokku = getSeqLength(i);
//        if (kokku > algArv){
//        algArv = kokku;