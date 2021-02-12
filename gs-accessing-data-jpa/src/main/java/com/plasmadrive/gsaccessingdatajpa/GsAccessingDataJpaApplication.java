package com.plasmadrive.gsaccessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GsAccessingDataJpaApplication {

    private static final Logger logger = LoggerFactory.getLogger(GsAccessingDataJpaApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(GsAccessingDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo (CustomerRepository customerRepository) throws Exception {
        return args -> {
            logger.info("Inserting data");
            customerRepository.save(new Customer("Gareth","Brown"));
            customerRepository.save(new Customer("Sandra","Green"));
            customerRepository.save(new Customer("Fred","Foobar"));
            customerRepository.save(new Customer("Paul","Brown"));

            logger.info("Retrieving all customers");
            Iterable<Customer> customers = customerRepository.findAll();
            for (Customer customer : customers) {
                logger.info(customer.toString());
            }

            logger.info("Find customer by id");
            logger.info(customerRepository.findById(1l).toString());

            logger.info("Find customers by last name");
            for (Customer customer: customerRepository.findByLastName("Brown")) {
                logger.info(customers.toString());
            }

        };
    }

}
