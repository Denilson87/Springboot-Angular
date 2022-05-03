package com.app.servers.service.serverImplementation;

import com.app.servers.model.Server;
import com.app.servers.repositories.ServerRepository;
import com.app.servers.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

import static com.app.servers.Status.SERVER_DOWN;
import static com.app.servers.Status.SERVER_UP;
import static java.lang.Boolean.*;
import static java.util.List.of;
import static java.util.stream.Collectors.toList;
import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class ServerServiceImplementation implements ServerService {

    private final ServerRepository serverRepository;

    @Override
    public Server create(Server server) {
        log.info("saving server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepository.save(server);
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all servers");
        return serverRepository.findAll(of(0, limit)).toList();
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("pinging server IP: {}", ipAddress);
        Server server = serverRepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    @Override
    public Server get(Long id) {
        log.info("Getting server by id : {}", id);
        return serverRepository.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("updating server", server.getName());
        return serverRepository.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("deleting server by id : {}", id);
        serverRepository.deleteById(id);
        return TRUE;
    }

    private String setServerImageUrl() {
        String[] imageNames={"server1.png","server2.png","server3.png","server4.png"};
        return null;
    }
}
