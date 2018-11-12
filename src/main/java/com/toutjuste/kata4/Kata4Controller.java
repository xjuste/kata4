package com.toutjuste.kata4;

import com.toutjuste.kata4.model.Kata4ErrorResponse;
import com.toutjuste.kata4.model.Kata4Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Controller
public class Kata4Controller {
    private static final String validProviders = "^(PWC|BLU)$";

    @GetMapping(value = "/cf")
    @ResponseBody
    public String getCF() {
        //TODO real implementation
        return "[{\n" +
                "description: xx\n" +
                "api_version: yy\n" +
                "},\n" +
                "{\n" +
                "Description: xx1\n" +
                "api_version: yy1\n" +
                "} ]\n";
    }

    @GetMapping(value = "/cf/{provider}")
    @ResponseBody
    public ResponseEntity<String> getCF(@PathVariable("provider") String provider) {
        if (!provider.matches(validProviders)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Kata4ErrorResponse().toString());
        }
        //TODO real implementation
        return ResponseEntity.ok("{\n" +
                "description: xx\n" +
                "api_version: yy\n" +
                "}\n");
    }
}
