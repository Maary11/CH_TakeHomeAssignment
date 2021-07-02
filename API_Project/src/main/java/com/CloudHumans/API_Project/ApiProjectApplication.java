package com.CloudHumans.API_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProjectApplication.class, args);
	}

	@PostMapping(path = "/post")
	public String customerInformation(@RequestBody Pro pro) {
		return pro.scoreEvaluation(pro.getAge(), pro.getEducation_level(), pro.getWriting_score(), pro.getReferral_code(), pro.getPast_experiences(), pro.getInternet_test()).toString();
	}

}
