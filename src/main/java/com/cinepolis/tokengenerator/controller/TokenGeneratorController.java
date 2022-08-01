package com.cinepolis.tokengenerator.controller;

import com.cinepolis.tokengenerator.models.TokenRequestBodyModel;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class TokenGeneratorController {

    // TODO: Implementar JSON con mejores prácticas? (https://www.baeldung.com/jackson-object-mapper-tutorial)
    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public HashMap<String, Object> generateToken(@RequestBody TokenRequestBodyModel tokenRequestBodyModel) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("token", tokenRequestBodyModel.generatedToken());
        return response;
    }
}
