package ru.onegines.springcourse.controllers;

import org.intellij.lang.annotations.Pattern;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/**
 * @author onegines
 * @date 06.09.2024
 */
@Controller
@RequestMapping("/first")
public class CalculatorController {
    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value = "a") int a,
                            @RequestParam(value = "b") int b,
                            @RequestParam(value = "action") String action,
                            Model model) {
        List<String> allowedValues = Arrays.asList("multiplication", "addition", "subtraction", "division");
        if (!allowedValues.contains(action)) {
            throw new IllegalArgumentException("Invalid type parameter");
        }
        double result = 0;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / b;
                break;
        }
        model.addAttribute("result", "Result: " + result);
        return "first/calculator";
    }
}
