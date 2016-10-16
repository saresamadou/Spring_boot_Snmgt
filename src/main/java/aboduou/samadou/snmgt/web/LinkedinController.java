package aboduou.samadou.snmgt.web;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/linki")
public class LinkedinController
{
	private LinkedIn linkedin;
	private ConnectionRepository connectionRepository;
	UserProfile userProfile;

	@Inject
	public LinkedinController(LinkedIn linkedin, ConnectionRepository connectionRepository) 
	{
	    this.linkedin = linkedin;
	    this.connectionRepository = connectionRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String helloLinkedIn(Model model)
	{
		if (connectionRepository.findPrimaryConnection(LinkedIn.class) == null) 
		{
			return "redirect:/connect/linkedin";
		}

		LinkedInProfile profile = linkedin.profileOperations().getUserProfile();

		String profileId = linkedin.profileOperations().getProfileId();
		model.addAttribute("profile", linkedin.profileOperations().getProfileId());

		return "linkedin";
	}

}
