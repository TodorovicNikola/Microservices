package rs.uns.ac.rs.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import org.json.simple.JSONObject;
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
	
	
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> getUsers(@RequestHeader("Authorization") String authorization)
	{
		System.out.println("getUsers method authorization token : " + authorization);
		return userService.getAllUsers();
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody JSONObject login(
			@RequestParam(name = "mail") String mail,
			@RequestParam(name = "password") String password){
		
		System.out.println("Login users");
		
		User loggedIn= userService.login(mail, password);
		if (loggedIn!=null)
		{
			return userService.getTokenForUser(loggedIn);
		}
		return null;
	}
	
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public @ResponseBody Object registerUser(@RequestBody @Valid  User user,@RequestHeader("Authorization") String authorization){
		
		//check if role is admin
		String role=userService.getUserRoleFromToken(authorization);
		if (!role.equals("admin"))
		{
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		System.out.println(user.getFirstName());
		if (userService.registerUser(user)!=null)
			return new ResponseEntity<>(HttpStatus.OK);
		return null;
		
	}
	
	@RequestMapping(value="/checkUserRole",method=RequestMethod.GET)
	public Boolean checkUserRole(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("role") String role)
	{
		System.out.println("USER SERVICE CHECK ROLE");
		return ((User)(userService.getOneUserByFirstAndLastName(firstName, lastName))).getRole().equals(role);
	}
	

	
}