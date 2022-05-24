package com.sof3021.assignment.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.rolling.helper.FileStoreUtil;

@Controller
public class Index {

	@GetMapping("home")
	public String Home() {
		return "layout";
	}
}
