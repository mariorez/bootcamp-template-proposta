package br.com.zup.bootcamp.proposta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PropostaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropostaApplication.class, args);
    }

}
