<%@page import="dal.asdc.controllers.Menu_controller"%>

<jsp:useBean id="menu_input" scope="page" class="Menu_controller.java" />

String main_menu = request.getParameter("main_menu_selection");

menu_input.show_menu("menu_sel");