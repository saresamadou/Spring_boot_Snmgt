package aboduou.samadou.snmgt.profiles;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProductionProfile
{
	private String description;

	public String getDescription()
	{
		return "This is a production environnement here";
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
	
}
