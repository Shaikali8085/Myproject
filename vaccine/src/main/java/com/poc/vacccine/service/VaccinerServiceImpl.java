package com.poc.vacccine.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.vacccine.dao.VaccineDAO;
import com.poc.vacccine.dto.VaccineDTO;
import com.poc.vacccine.entity.VaccineEntity;
import com.poc.vacccine.util.MailDispatcher;

@Service
public class VaccinerServiceImpl implements VaccinerService {

	@Autowired
	private VaccineDAO vaccineDAO;

	@Autowired
	private MailDispatcher mailDispatcher;

	public VaccinerServiceImpl() {
		System.out.println(getClass().getSimpleName() + "object is created");
	}

	public boolean registerVacciner(VaccineDTO dto) {
		System.out.println("invoked registerVacciner");
		VaccineEntity vaccineEntity = new VaccineEntity();
		BeanUtils.copyProperties(dto, vaccineEntity);
		boolean result = this.vaccineDAO.saveVaccineDTO(vaccineEntity);
		if (result) {
			this.mailDispatcher.SendOTP(dto.getEmail(), "Vaccination Notification",
					"Vaccination is succesfully done  ");
			return true;
		} else {
			System.out.println("somethig went wrong try again");
		}
		return false;
	}
}