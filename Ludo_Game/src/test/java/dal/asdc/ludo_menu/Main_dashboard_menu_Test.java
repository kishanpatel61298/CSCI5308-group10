package dal.asdc.ludo_menu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dal.asdc.ludo_menu.Main_dashboard_menu.Main_menu;
import dal.asdc.ludo_menu.Main_dashboard_menu.menu_options;
import dal.asdc.ludo_menu.Main_dashboard_menu.redirect_class;

class Main_dashboard_menu_Test {

private Main_dashboard_menu main_dash_menu;
private Main_menu main_menu;
	
	@BeforeEach
	void initEach() {
		main_dash_menu = new Main_dashboard_menu();
	}
	
	@Test
	void Get_menu_LoginTest() {
		main_menu.menu = menu_options.LOGIN;
		assertEquals(redirect_class.Player_login,main_menu.get_menu_page());
	}
	
	@Test
	void Get_menu_RegisterTest() {
		main_menu.menu = menu_options.REGISTER;
		assertEquals(redirect_class.Player_register,main_menu.get_menu_page());
	}
	
	@Test
	void Get_menuTest() {
		main_menu.menu = menu_options.EXIT;
		assertEquals(redirect_class.Player_login,main_menu.get_menu_page());
	}
}
