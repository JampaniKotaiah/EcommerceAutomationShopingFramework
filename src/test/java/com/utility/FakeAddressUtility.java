package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.RegistrationPojo;

public class FakeAddressUtility {
	
	public static RegistrationPojo getFakeAddress() {
		
		Faker faker = new Faker(Locale.US);
		RegistrationPojo registrationPojo = 	
		new RegistrationPojo(faker.name().firstName(), faker.name().lastName(), faker.company().name(), faker.address().buildingNumber(), faker.address().streetAddress(), faker.address().state(), faker.address().city(),faker.address().zipCode(),faker.phoneNumber().cellPhone());
		return registrationPojo;
	}

}
