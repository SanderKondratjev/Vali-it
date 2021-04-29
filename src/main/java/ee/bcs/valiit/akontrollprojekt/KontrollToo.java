package ee.bcs.valiit.akontrollprojekt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class KontrollToo {
//    String question = "Kas java on javascript";
//    String x = "";
    int punkte = 0;
    String vastus = "ei";

    @GetMapping("kontrolltestimiseks/{x}")
    public String lesson3hard(@PathVariable("x") String x) {
        if (vastus.equalsIgnoreCase(x)) {
            punkte++;
            return "Õige vastus. Kokku on sul punkte " + punkte;
        } else {
            return "Vale vastus. Kokku on sul punkte " + punkte;
        }
    }
}
//    }
//
//
//    int
//    boolean valitud6ige = false;
//
//
//        System.out.println("Arva ära number vahemikus 0-99.");
//    Scanner scanner = new Scanner(System.in);
//        for (int j = 100; j > 0; j--) {
//        arvatudNumbreid++;
//        int arvanudNumber = scanner.nextInt();
//        if (i < arvanudNumber) {
//            System.out.println("Arv on väiksem kui sinu arv: " + arvanudNumber);
//        } else if (i > arvanudNumber) {
//            System.out.println("Arv on suurem kui sinu arv: " + arvanudNumber);
//        } else {
//            valitud6ige = true;
//            break;
//        }
//
//    }
//        System.out.println("Õige! Number oli " +i);
//        System.out.println("Sa arvasid " + arvatudNumbreid + " korda");

