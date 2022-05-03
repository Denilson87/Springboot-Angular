package com.app.servers.repositories;

import com.app.servers.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository <Server, Long> {
    Server findByIpAdress(String ipAddress);
}
