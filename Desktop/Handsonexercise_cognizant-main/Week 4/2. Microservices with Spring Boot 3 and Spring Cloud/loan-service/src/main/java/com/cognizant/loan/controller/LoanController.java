package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;

@RestController
public class LoanController {
    @GetMapping("/loans/{number}")
    public Map<String, Object> getLoan(@PathVariable String number) {
        Map<String, Object> res = new HashMap<>();
        res.put("number", number);
        res.put("type", "car");
        res.put("loan", 400000);
        res.put("emi", 3258);
        res.put("tenure", 18);
        return res;
    }
}
