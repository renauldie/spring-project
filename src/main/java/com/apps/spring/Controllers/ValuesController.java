package com.apps.spring.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/values")
public class ValuesController {

    @GetMapping
    public ResponseEntity<String> values() {
        return ResponseEntity.ok("Application Running");
    }
}
