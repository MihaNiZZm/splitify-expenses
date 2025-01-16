package ru.mihanizzm.splitify.splitifyexpenses;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SplitifyExpensesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SplitifyExpensesApplication.class, args);
    }
}
