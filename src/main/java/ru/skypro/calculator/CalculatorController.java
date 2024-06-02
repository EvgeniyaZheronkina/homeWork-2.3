package ru.skypro.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greatings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/sum")
    public String sum(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return a + " + " + b + " = " + calculatorService.sum(a, b);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return a + " - " + b + " = " + calculatorService.minus(a, b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return a + " * " + b + " = " + calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        if (b == 0) {
            return "Делить на 0 нельзя";
        }
        return a + " / " + b + " = " + calculatorService.divide(a, b);
    }

}
