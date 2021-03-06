package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson1;
import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    public List<DTO> listTootajad = new ArrayList<>();

    @GetMapping("hello-world/{nameInUrl}")
    public String helloWorld(@PathVariable("nameInUrl") String name,
                             @RequestParam("action") String a,
                             @RequestParam("action2") String b) {
        return a + " " + name + " " + b;
    }

    @GetMapping("fib/{n}")
    public int fib(@PathVariable("n") int n) {
        return Lesson2.fibonacci(n);
    }

    @GetMapping("min/{a}/{b}")
    public int min(@PathVariable("a") int a, @PathVariable("b") int b) {
        return Lesson1.min(a, b);
    }

    @GetMapping("max/{a}/{b}")
    public int max(@PathVariable("a") int a, @PathVariable("b") int b) {
        return Lesson1.max(a, b);
    }

    @GetMapping("abs/{a}")
    public int abs(@PathVariable("a") int a) {
        return Lesson1.abs(a);
    }

    @GetMapping("iseven/{a}")
    public boolean isEven(@PathVariable("a") int a) {
        return Lesson1.isEven(a);
    }

    @GetMapping("min3/{a}/{b}/{c}")
    public int min3(@PathVariable("a") int a,
                    @PathVariable("b") int b,
                    @PathVariable("c") int c) {
        return Lesson1.min3(a, b, c);
    }

    @GetMapping("max3/{a}/{b}/{c}")
    public int max3(@PathVariable("a") int a,
                    @PathVariable("b") int b,
                    @PathVariable("c") int c) {
        return Lesson1.max3(a, b, c);
    }

    @GetMapping("evennumbers/{n}")
    public int[] evenNumbers(@PathVariable("n") int n) {
        return Lesson2.evenNumbers(n);
    }

    @GetMapping("min5/{x}")
    public int min(@PathVariable("x") int[] x) {
        return Lesson2.min(x);
    }

    @GetMapping("max5/{x}")
    public int max(@PathVariable("x") int[] x) {
        return Lesson2.max(x);
    }

    @GetMapping("sum5/{x}")
    public int sum(@PathVariable("x") int[] x) {
        return Lesson2.sum(x);
    }

    @GetMapping("fact/{x}")
    public int fact(@PathVariable("x") int x) {
        return Lesson3.factorial(x);
    }

    @GetMapping("reverse/{a}")
    public String reverse(@PathVariable("a") String a) {
        return Lesson3.reverseString(a);
    }

    @GetMapping("isprime/{x}")
    public boolean isPrime(@PathVariable("x") int x) {
        return Lesson3.isPrime(x);
    }

    @GetMapping("sort/{x}")
    public int[] sort(@PathVariable("x") int[] x) {
        return Lesson3.sort(x);
    }

    @GetMapping("evenfib/{x}")
    public int evenFib(@PathVariable("x") int x) {
        return Lesson3.evenFibonacci(x);
    }

    @GetMapping("morese/{text}")
    public String morseCode(@PathVariable("text") String text) {
        return Lesson3.morseCode(text);
    }

    @GetMapping("tootajad")
    public List<DTO> tootajad() {
        return listTootajad;
    }

    @GetMapping("tootajad/{x}")
    public DTO otsi(@PathVariable("x") int x) {
        return listTootajad.get(x);
    }

    @PostMapping("tootajad")
    public void tootajad(@RequestBody DTO tootajad) {

        listTootajad.add(tootajad);
    }

    @PutMapping("tootajad/{x}")
    public DTO kirjutaYle(@PathVariable("x") int x, @RequestBody DTO tootajad) {
        return (listTootajad.set(x, tootajad));
    }

    @DeleteMapping("tootajad/{x}")
    public DTO kustuta(@PathVariable("x") int x) {
        return listTootajad.remove(x);
    }

    @GetMapping("testing/3/{c}")
    public int miingi(@RequestParam("a") int a,
                      @RequestParam("b") int b,
                      @PathVariable("c") int c) {
        return a - b;
    }

    @GetMapping("katsetamiseks/a/{b}/b/{a}")
    public void test(@RequestParam("c") int a,
                     @PathVariable("a") int b,
                     @RequestParam("a") int c,
                     @PathVariable("b") int d) {

    }

    @GetMapping("igaksjuhuks/{a}/{b}")
    public String igaks(@PathVariable("b") String a,
                      @PathVariable("a") int c,
                      @RequestParam("a") String b) {
        return "Path b = "+ a+ " Path a = " + c + "Req a = " +b;

    }


}
