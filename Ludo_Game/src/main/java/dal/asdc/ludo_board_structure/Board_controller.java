package dal.asdc.ludo_board_structure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Board_controller {

	@RequestMapping("home")
	public String home() {
		return "ludo_board.jsp";
	}
}
