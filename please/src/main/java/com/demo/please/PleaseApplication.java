package com.demo.please;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class})
public class PleaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PleaseApplication.class, args);
    }

}
