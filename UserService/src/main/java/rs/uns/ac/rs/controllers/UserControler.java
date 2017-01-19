package rs.uns.ac.rs.controllers;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ac.rs.models.User;
import rs.uns.ac.rs.services.UserService;


@RestController
public class UserControler extends AbstractRESTController<User, String>{
	
	@Autowired
	Environment environment;
	
	private UserService userService;
	

	@Autowired
	public UserControler(UserService userService) {
		super(userService);
		this.userService = userService;
	}
	
	@RequestMapping("/initUsers")
	public String initUsers(){
		
		System.out.println("Init users");
		User nikola=new User();
		nikola.setFirstName("Nikola");
		nikola.setLastName("Todorovic");
		nikola.setPassword("nikola");
		nikola.setMail("nikola@gmail.com");
		userService.save(nikola);
		
		User aleksa=new User();
		aleksa.setFirstName("Aleksa");
		aleksa.setLastName("Mirkovic");
		aleksa.setPassword("aleksa");
		aleksa.setMail("aleksa@gmail.com");
		userService.save(aleksa);
		
		return "Success";
		
		
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User login(
			@RequestParam(name = "mail") String mail,
			@RequestParam(name = "password") String password){
		return userService.login(mail, password);
	}
	
}