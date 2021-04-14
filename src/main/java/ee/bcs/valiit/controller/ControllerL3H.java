package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.Scanner;

@RestController
public class ControllerL3H {
    static Random random = new Random();
    static int i = random.nextInt(100);
    int arvatudNumbreid = 0;

    @GetMapping("lesson3hard/{x}")
    public String lesson3hard(@PathVariable("x") int x) {
        if (i < x) {
            arvatudNumbreid++;
            return "Arv on väiksem kui sinu arv: " + x;
        } else if (i > x) {
            arvatudNumbreid++;
            return "Arv on suurem kui sinu arv: " + x;
        } else {
            return "Õige! Sa arvasid " + arvatudNumbreid + " korda";
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

