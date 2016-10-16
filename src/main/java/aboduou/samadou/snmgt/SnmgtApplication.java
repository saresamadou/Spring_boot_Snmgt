package aboduou.samadou.snmgt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnmgtApplication implements CommandLineRunner
{
	Logger logger = LoggerFactory.getLogger(SnmgtApplication.class);

	  
	public static void main(String[] args)
	{
		SpringApplication app = new SpringApplication(SnmgtApplication.class);
		app.setBannerMode(Banner.Mode.OFF);//Disable banner mode
		app.run(args);
	}
	

	  public void run(String... args)
	  {
		
	  }
}
