package com.lohith.mypaymentwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddBankController {
	@GetMapping("addbankaccount")
	public String addBankAccount() {
		return "addbankaccount";
	}
}
