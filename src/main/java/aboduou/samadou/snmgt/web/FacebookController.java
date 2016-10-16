package aboduou.samadou.snmgt.web;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FriendList;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/face")
public class FacebookController
{
	private Facebook facebook;
	private ConnectionRepository connectionRepository;
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Inject
	public FacebookController(Facebook facebook, ConnectionRepository connectionRepository)
	{
		this.facebook = facebook;
		this.connectionRepository = connectionRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String helloFacebook(Model model)
	{
		if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
			return "redirect:/connect/facebook";
		}

		model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
		PagedList<Post> feed = facebook.feedOperations().getFeed();
		List<String> friendIds = facebook.friendOperations().getFriendIds();
		log.info("Friends Size " + friendIds.size());
		model.addAttribute("feed", feed);

		return "facebook";
	}
}
