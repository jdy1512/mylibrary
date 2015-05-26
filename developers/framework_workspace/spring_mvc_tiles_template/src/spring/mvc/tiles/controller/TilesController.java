package spring.mvc.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {
	
	@RequestMapping("mainpage")
	public String mainPage() {
		return "main.tiles";
	}
	
	@RequestMapping("join_form")
	public String joinForm() {
		return "member/join_form.tiles";
	}
	
	@RequestMapping("register_form")
	public String registerForm() {
		return "product/register_form.tiles";
	}
	
	@RequestMapping("no_tiles")
	public String noTiles() {
		return "/WEB-INF/view/no_tiles.jsp";
	}
}
