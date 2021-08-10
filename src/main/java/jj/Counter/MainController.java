package jj.Counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
    public String index(HttpSession session) {
		if (session.getAttribute("visit") == null ) {
		session.setAttribute("visit", 1);
		} else 
		{
			session.setAttribute("visit", (int) session.getAttribute("visit") + 1);
		}
		 return "index.jsp";
    }
	@RequestMapping("/results")
	 public String results(HttpSession session,Model model) {
			model.addAttribute("visit",(int) session.getAttribute("visit"));
		
		return "results.jsp";
		
	}
}
