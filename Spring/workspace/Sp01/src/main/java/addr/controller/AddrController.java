package addr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/addr")
public class AddrController {
	@RequestMapping("")
	public void list() {

	}
}
