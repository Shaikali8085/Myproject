package com.poc.vacccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poc.vacccine.dto.VaccineDTO;
import com.poc.vacccine.entity.VaccineEntity;
import com.poc.vacccine.service.VaccinerService;
import com.poc.vacccine.util.MailDispatcher;
import com.poc.vacccine.util.OtpGenerator;

@Controller
public class VaccineController {

	@Autowired
	private VaccinerService vaccinerService;

	public VaccineController() {
		System.out.println(getClass().getSimpleName() + "object is created");
	}

	@RequestMapping(value = "/register.do")
	public String onRegister(@ModelAttribute VaccineDTO dto, Model model) {
		System.out.println("Invoked onRegister Method");
		System.out.println(dto);
		boolean outcome = this.vaccinerService.registerVacciner(dto);
		if (outcome) {
			model.addAttribute("vaccinemessage", "vaccine Application Successfull done");
			return "home2";
		} else {
			model.addAttribute("vaccinemessage", " Application Failed try again later");
			return "home2";

		}

	}

}