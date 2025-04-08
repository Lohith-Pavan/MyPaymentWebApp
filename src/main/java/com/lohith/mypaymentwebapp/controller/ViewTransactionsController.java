package com.lohith.mypaymentwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTransactionsController {
	@GetMapping("detailedstatementpage")
	public String viewTransactions() {
		return "detailedstatementpage";
	}
}
