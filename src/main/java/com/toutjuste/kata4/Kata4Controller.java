package com.toutjuste.kata4;

import com.toutjuste.kata4.model.Kata4Response;
import com.toutjuste.kata4.service.Kata4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Kata4Controller {
    private static final String validProviders = "^(PWC|BLU)$";

    private Kata4Service kata4Service;

    @Autowired
    public Kata4Controller(Kata4Service kata4Service) {
        this.kata4Service = kata4Service;
    }

    @GetMapping(value = "/cf")
    @ResponseBody
    public ResponseEntity getCF() {
        List<Kata4Response> response = kata4Service.getProviders();
        if (!response.isEmpty()) {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/cf/{provider}")
    @ResponseBody
    public ResponseEntity<List<Kata4Response>> getCF(@PathVariable("provider") String provider) {
        if (provider.matches(validProviders)) {
            List<Kata4Response> response = kata4Service.getProviders(provider);
            if (!response.isEmpty()) {
                return ResponseEntity.ok().body(response);
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
