package aboduou.samadou.snmgt.profiles;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevelopmentProfile
{
	private String description;
	private static final String logFileName = "snmgt-dev.log";

	public String getDescription()
	{
		return "This is a development environnement here";
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getLogFileName()
	{
		return logFileName;
	}
}
