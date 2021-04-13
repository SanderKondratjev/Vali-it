package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(100);
        int arvatudNumbreid = 0;
        boolean valitud6ige = false;


        System.out.println("Arva ära number vahemikus 0-99.");
        Scanner scanner = new Scanner(System.in);
        for (int j = 100; j > 0; j--) {
            arvatudNumbreid++;
            int arvanudNumber = scanner.nextInt();
            if (i < arvanudNumber) {
                System.out.println("Arv on väiksem kui sinu arv: " + arvanudNumber);
            } else if (i > arvanudNumber) {
                System.out.println("Arv on suurem kui sinu arv: " + arvanudNumber);
            } else {
                valitud6ige = true;
                break;
            }

        }
        System.out.println("Õige! Number oli " +i);
        System.out.println("Sa arvasid " + arvatudNumbreid + " korda");
    }
}
