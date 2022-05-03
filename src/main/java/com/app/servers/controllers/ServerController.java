package com.app.servers.controllers;

import com.app.servers.model.Response;
import com.app.servers.service.serverImplementation.ServerServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.util.Map.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/server")

public class ServerController {
    private final ServerServiceImplementation serverService;

    @GetMapping("/list")
    public ResponseEntity<Response> getServer(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("servers",serverService.list(30)))
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
