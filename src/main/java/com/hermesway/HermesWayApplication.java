package com.hermesway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * HERMES WAYアプリケーションのエントリーポイント
 */
@SpringBootApplication
@EnableJpaAuditing
public class HermesWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HermesWayApplication.class, args);
    }
}