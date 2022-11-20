package com.newspaper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MyNewspaperApplication implements CommandLineRunner {

//	@Autowired
//	private IUserService userService;
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(MyNewspaperApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		User user = new User();
//		user.setFirstName("Admin");
//		user.setLastName("Service");
//		user.setEmail("admin@gmail.com");
//		user.setPassword("123");
//		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
//		user.setContact("8878821887");
//		user.setUserName("Admin123");
//		user.setRole("ADMIN");
//		user.setEnabled(true);
//		this.userService.createUser(user);

	}

}
