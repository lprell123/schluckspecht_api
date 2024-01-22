package schluckspecht.backendapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import schluckspecht.backendapp.Contactdata.ContactRepo;
import schluckspecht.backendapp.Contactdata.Contactform;
import schluckspecht.backendapp.Feedpostdata.Feedpost;
import schluckspecht.backendapp.Feedpostdata.FeedpostRepo;
import schluckspecht.backendapp.Timelinedata.TimelineRepo;
import schluckspecht.backendapp.Timelinedata.Timelinepost;


@SpringBootApplication
public class BackendappApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendappApplication.class);
	}

	@Bean
	public CommandLineRunner demo(FeedpostRepo repository) {
		return (args) -> {

			//hier posts erstellen mit repository.save(new Feedpost());
			repository.save(new Feedpost("post1test", "testpost one is being displayed", "today"));
			repository.save(new Feedpost("post2test", "testpost two is being displayed", "today", "assets/images/2019_Berghem.jpg"));
			repository.save(new Feedpost("post3test", "testpost three is being displayed", "today", "assets/images/2019_Berghem.jpg"));
			repository.save(new Feedpost("post4test", "testpost four is being displayed", "today"));
			repository.save(new Feedpost("post5test", "testpost five is being displayed", "today", "assets/images/2019_Berghem.jpg"));

			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			Feedpost customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByDate("today").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}

	@Bean
	public CommandLineRunner demo2(ContactRepo repository) {
		return (args) -> {

			//hier kontakt form erstellen mit repository.save(new Contactform());
			repository.save(new Contactform("Fleig, Claus", "CEO", "+49 1704563", "maxmuster@web.de", "assets/Fleig.jpg"));
			repository.save(new Contactform("Hensel, Stefan", "CTO", "assets/Hensel.jpg"));
			repository.save(new Contactform("Jane Doe", "CTO", "janedoe@example.com", "assets/Hensel.jpg"));

			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			Contactform customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");
		};
	}

	@Bean
	public CommandLineRunner demo3(TimelineRepo repository) {
		return (args) -> {

			//hier timelinepost erstellen mit repository.save(new Timelinepost());
			repository.save(new Timelinepost(12, 3, 2000, "Deutschland", "Testevent1", "20", "irgendein Event", "Testtag", "Hello World", "assets/testimage.jpg"));
			repository.save(new Timelinepost(13, 2, 2002, "Deutschland", "Testevent2", "20", "irgendein Event", "Testtag", "Hello World", "assets/testimage.jpg"));
			repository.save(new Timelinepost(14, 4, 2004, "Deutschland", "Testevent3", "20", "irgendein Event", "Testtag", "Hello World", "assets/testimage.jpg"));

			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			Timelinepost customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");
		};
	}

}
