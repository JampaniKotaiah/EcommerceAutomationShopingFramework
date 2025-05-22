package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.LoginPojo;
import com.ui.pojo.RegistrationPojo;

public class FakeAddressUtility {
	
	private static Faker faker = new Faker(Locale.US);
	
	public static RegistrationPojo getFakeAddress() {
		
		RegistrationPojo registrationPojo = 	
		new RegistrationPojo(faker.name().firstName(), faker.name().lastName(), faker.company().name(), faker.address().buildingNumber(), faker.address().streetAddress(), faker.address().state(), faker.address().city(),faker.address().zipCode(),faker.phoneNumber().cellPhone());
		return registrationPojo;
	}
	
	public static LoginPojo getFakeMailAndPassword() {
		
		LoginPojo loginPojo = new LoginPojo(faker.name().username(),faker.internet().emailAddress(), faker.internet().password());
		return loginPojo;
		
	}

}
