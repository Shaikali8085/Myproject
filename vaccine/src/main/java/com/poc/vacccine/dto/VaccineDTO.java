package com.poc.vacccine.dto;

public class VaccineDTO {

	private String name;
	private String email;
	private int otp;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public VaccineDTO() {
		System.out.println(getClass().getSimpleName() + "object is created");
	}

	@Override
	public String toString() {
		return "VaccineDTO [name=" + name + ", email=" + email + ", otp=" + otp + "]";
	}

}