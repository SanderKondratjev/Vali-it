package ee.bcs.valiit.tests;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {

        //    ÜL 1
//    Tee funktsioon, mis tagastab boolean väärtuse ja võtab sisse ühe parameetri
//    funktsioon peab tagastama
//		true: kui sisend parameeter jagub 3 või 7 (aga ei jagu mõlema numbriga)
//            false: kui sisend parameeter ei jagu 3 ega 7 või jagub mõlema numbriga
        int a = 35;
        boolean väärtus = false;
        if (a % 3 == 0 || a % 7 == 0) {
            if (a % 3 == 0 && a % 7 != 0) {
                väärtus = true;
            } else if (a % 3 != 0 && a % 7 == 0) {
                väärtus = true;
            }
        } else
            väärtus = false;
        System.out.println(väärtus);
    }


    // ÜL2
    // lisa x igale array elemendile
    // Näiteks
    // sisend [1,2,3], 5
    // vastus [6,7,8]
    public static int[] addToArray(int[] array, int x) {
        int pikkus = array.length;
        int[] elemendid = new int[pikkus];
        for (int i = 0; i < pikkus; i++) {
            elemendid[i] = array[i]+x;
        }
        return elemendid;
    }
    public static int[] uusArray(int[] array) {
            array[0] = 0;
        return array;
    }
}
