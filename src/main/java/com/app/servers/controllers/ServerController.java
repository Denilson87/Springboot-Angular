package com.app.servers.controllers;

import com.app.servers.service.serverImplementation.ServerServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("server/api/")

public class ServerController {
    private final ServerServiceImplementation ServerService;
}
