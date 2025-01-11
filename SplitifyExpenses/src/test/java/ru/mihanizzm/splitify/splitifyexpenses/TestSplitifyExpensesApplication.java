package ru.mihanizzm.splitify.splitifyexpenses;

import org.springframework.boot.SpringApplication;

public class TestSplitifyExpensesApplication {

    public static void main(String[] args) {
        SpringApplication.from(SplitifyExpensesApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
