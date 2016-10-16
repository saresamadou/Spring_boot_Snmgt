package aboduou.samadou.snmgt;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorsController extends BasicErrorController
{

	public ErrorsController(ErrorAttributes errorAttributes, ErrorProperties errorProperties)
	{
		super(errorAttributes, errorProperties);
	}
	
	@RequestMapping("/error")
	public String handleError()
	{
		return "error";
	}

}
