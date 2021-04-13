package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson1;
import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("sample/hello-world/{nameInUrl}")
    public String helloWorld(@PathVariable("nameInUrl") String name,
                             @RequestParam("action") String a,
                             @RequestParam("action2") String b) {
        return a + " " + name + " " + b;
    }

    @GetMapping("sample/fib/{n}")
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
}
