package ee.bcs.valiit.tasks;

import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        // Siia sisse võid sa kirjutada koodi, et testida kas su meetodid töötavad ilusti
        // Katseta IntelliJ shortcuti. Olles intelliJ kirjuta "sout" ja siis vajuta enter
        //System.out.println(min(1, 3)); // trükib miinimumi 1 ja 3
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mis ülesannet soovid lahendada? (min, max, abs, isEven, min3, max3):");

        String valik = scanner.nextLine();

        switch (valik) {
            case "min": {
                System.out.println("Sisesta a");
                int a = scanner.nextInt();
                System.out.println("Sisesta b");
                int b = scanner.nextInt();
                System.out.println(min(a, b));
                break;
            }
            case "max": {
                System.out.println("Sisesta a");
                int a = scanner.nextInt();
                System.out.println("Sisesta b");
                int b = scanner.nextInt();
                System.out.println(max(a, b));
                break;
            }
            case "abs": {
                System.out.println("Sisesta a");
                int a = scanner.nextInt();
                if (a > 0) {
                    System.out.println(a);
                } else {
                    System.out.println(a * -1);
                }
                break;
            }
            case "isEven": {
                System.out.println("Sisesta a");
                int a = scanner.nextInt();
                if ((a % 2) == 0) {
                    System.out.println(a);
                } else {
                    System.out.println("Ei ole paaris arv");
                }
                break;
            }
            case "min3": {
                System.out.println("Sisesta a");
                int a = scanner.nextInt();
                System.out.println("Sisesta b");
                int b = scanner.nextInt();
                System.out.println("Sisesta c");
                int c = scanner.nextInt();
                System.out.println(min(min(a, b), c));
                break;
            }
            case "max3": {
                System.out.println("Sisesta a");
                int a = scanner.nextInt();
                System.out.println("Sisesta b");
                int b = scanner.nextInt();
                System.out.println("Sisesta c");
                int c = scanner.nextInt();
                System.out.println(max(max(a, b), c));
                break;
            }
        }
    }
        // TODO tagasta a ja b väikseim väärtus
        public static int min ( int a, int b){
            if (a < b) {
                return a;
            } else {
                return b;
            }
        }

        // TODO tagasta a ja b suurim väärtus
        public static int max ( int a, int b){
            if (a > b) {
                return a;
            } else {
                return b;
            }
        }

        // TODO tagasta a absoluut arv
        public static int abs ( int a){
            if (a > 0) {
                return a;
            } else {
                return (a * -1);
            }
        }

        // TODO tagasta true, kui a on paaris arv
        // tagasta false kui a on paaritu arv
        public static boolean isEven ( int a){
            if ((a % 2) == 0) {
                return true;
            } else {
                return false;
            }
        }

        // TODO tagasta kolmest arvust kõige väiksem
        public static int min3 ( int a, int b, int c){
            if (a <= b && a <= c) {
                return a;
            } else if (b <= c && b <= a) {
                return b;
            } else {
                return c;
            }
        }

        // TODO tagasta kolmest arvust kõige suurem
        public static int max3 ( int a, int b, int c){
            if (a >= b && a >= c) {
                return a;
            } else if (b >= c && b >= a) {
                return b;
            } else {
                return c;
                // Lühem versioon: return max(max(a, b), c);
            }
        }
    }
