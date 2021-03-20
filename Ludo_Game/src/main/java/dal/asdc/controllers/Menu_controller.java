package dal.asdc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dal.asdc.model.Main_menu;

@Controller
public class Menu_controller {
	
	@Autowired
	Main_menu m_menu;
	
	@RequestMapping(value = "/")
	public String menu(Model model) {
		model.addAttribute("Main_menu", m_menu);
		return "Menu_display.jsp";
	}

	@RequestMapping(value="/d_menu", method=RequestMethod.POST)
	public String dash_menu(@RequestParam("sel_menu") String smenu, Model model) {
		model.addAttribute("smenu", smenu);
		return "Dashboard_menu.jsp";
	}
	
	
}
