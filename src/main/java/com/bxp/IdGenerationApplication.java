package com.bxp;

import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.bxp.dto.CustomerDTO;
import com.bxp.service.CustomerServiceImpl;

@SpringBootApplication
public class IdGenerationApplication implements CommandLineRunner {
	
	public static final Log LOGGER = LogFactory.getLog(IdGenerationApplication.class);
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(IdGenerationApplication.class,args);
	}
	
	public void run(String... args) throws Exception {
		addCustomer();
	}
	
	public void addCustomer() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setEmailId("Arya14@gmail.com");
		customerDTO.setName("Arya");
		customerDTO.setCreationTime(LocalTime.now());
		try {
			Integer id = customerService.addCustomer(customerDTO);
			System.out.println("--------------------------------------------------");
			
			System.out.println( "Ticket generated successfully with id:  " + id);
			System.out.println("--------------------------------------------------");
		} catch (Exception e) {
			if (e.getMessage() != null)
				System.out.println(e);
				LOGGER.info(environment.getProperty(e.getMessage(),"Something went wrong."));
		}
	
	}
	
}
