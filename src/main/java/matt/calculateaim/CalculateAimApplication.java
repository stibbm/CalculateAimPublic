package matt.calculateaim;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculateAimApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CalculateAimApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		System.out.println("explicitly exiting since spring boot will not automatically exit");
		System.exit(0);
	}

}
