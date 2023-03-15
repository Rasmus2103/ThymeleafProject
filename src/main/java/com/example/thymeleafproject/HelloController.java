package com.example.thymeleafproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Controller
@RequestMapping("hello")
public class HelloController {

    @GetMapping("say")
    public String sayHello(@RequestParam String name, Model model) {
        model.addAttribute("yoh","Hello " + name);
        return "hello";
    }

    @GetMapping("date")
    public String sayHello(Model model) {
        model.addAttribute("hello", "Todays date is: " + LocalDate.now());
        return "hello";
    }

    @GetMapping("weekday")
    public String sayWeekDays(Model model) {
        model.addAttribute("week", "The week are the following " + LocalDate.now().getDayOfWeek());
        return "hello";
    }

    @GetMapping("isFriday")
    public String isFriday(Model model) {
        LocalDate date = LocalDate.now();
        String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("DA", "DK"));
        model.addAttribute("currentDayOfWeek", "Dagen idag er : " + dayOfWeek);
        return "hello";
    }

}
