package com.apps.spring.Controllers.auth;

import com.apps.spring.Models.ResponseApi;
import com.apps.spring.Services.AuthenticationService;
import com.apps.spring.Models.request.AuthenticationRequest;
import com.apps.spring.Models.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request
    ) throws Exception {
        ResponseApi response = new ResponseApi();
        try {
            service.register(request);
            response.setCode("201");
            response.setMessage("Success to Register");
        } catch (Exception e) {
            response.setCode("422");
            response.setMessage("Unable to Register Data");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(
            @RequestBody AuthenticationRequest request
    ) {

        ResponseApi response = new ResponseApi();

        try {
            response.setCode("200");
            response.setMessage("Success to Authorize");
            response.setData(service.authenticate(request));
        } catch (Exception e) {
            response.setCode("401");
            response.setMessage("Failed to Authorize");
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }
}
