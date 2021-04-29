package ee.bcs.valiit.akontrollprojekt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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