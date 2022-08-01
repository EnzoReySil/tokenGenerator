package com.cinepolis.tokengenerator.controller;

import com.cinepolis.tokengenerator.models.TokenRequestBodyModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenGeneratorController {


    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> generateToken(@RequestBody TokenRequestBodyModel tokenRequestBodyModel) {
        return new ResponseEntity<>(tokenRequestBodyModel.generatedToken(), org.springframework.http.HttpStatus.OK);
    }
}
