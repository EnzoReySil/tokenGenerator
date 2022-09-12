package com.cinepolis.tokengenerator.controller;

import com.cinepolis.tokengenerator.models.TokenRequestBodyModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class TokenGeneratorController {

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public HashMap<String, Object> generateToken(@RequestBody TokenRequestBodyModel tokenRequestBodyModel) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("token", tokenRequestBodyModel.generatedToken());
        return response;
    }
}
