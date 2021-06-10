package br.gov.sp.etecsebrae.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@GetMapping({ "/", "/home", "/index" })
	public ModelAndView home() {
		return new ModelAndView("index");
	}
}
