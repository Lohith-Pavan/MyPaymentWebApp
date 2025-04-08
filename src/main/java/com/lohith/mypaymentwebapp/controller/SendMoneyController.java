package com.lohith.mypaymentwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SendMoneyController {
	@GetMapping("/sendmoney")
	public String sendMoney() {
		return "sendmoney";
	}
}
