package com.ts.springexamples.ftp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by rahul on 4/19/19.
 */
@SpringBootApplication
@ComponentScan("com.ts.springexamples")
public class FTPApp {
    public static void main(String[] args) {
        SpringApplication.run(FTPApp.class,args);
    }
}
