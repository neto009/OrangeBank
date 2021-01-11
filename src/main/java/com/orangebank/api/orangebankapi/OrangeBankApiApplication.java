package com.orangebank.api.orangebankapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrangeBankApiApplication implements CommandLineRunner {
    //private Logger logger = LoggerFactory.getLogger(this.getClass());
    //@Autowired
    //ClientRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(OrangeBankApiApplication.class, args);
	}
        @Override
        public void run(String... args) throws Exception {
            //Insert
            //logger.info("Inserting -> {}", repository.save(new ClientEntity("Solange","Solange@hotmail.com", "11111111111", new Date())));
        }

}
