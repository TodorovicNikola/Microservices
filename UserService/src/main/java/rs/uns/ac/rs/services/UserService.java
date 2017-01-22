package rs.uns.ac.rs.services;


import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import rs.uns.ac.rs.models.User;
import rs.uns.ac.rs.repositories.UserRepository;



@Service
public class UserService extends AbstractCRUDService<User, String>{

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository){
		super(userRepository);
		this.userRepository = userRepository;
	}

	public User login(String mail, String password){
		User user = userRepository.findByMail(mail);

		if(user != null){
			if(user.getPassword().equals(password)){
				return user;
			}
		}

		return null;
	}

	public String registerUser(User user)
	{
		if (save(user)!=null)
		{
			return "Success";
		}
		return null;
	}

	@SuppressWarnings( "unchecked" )
	public JSONObject getTokenForUser(User user)
	{
		try{
			byte[] encodedBytes = Base64.encodeBase64("smpos".getBytes());
			String smpos = new String(encodedBytes);
			JSONObject payload = new JSONObject();
			payload.put("firstName", user.getFirstName());
			payload.put("lastName",user.getLastName());
			payload.put("role", user.getRole());
			payload.put("id", user.getId());
			String jwt = (Jwts.builder().setPayload(payload.toJSONString()).signWith(SignatureAlgorithm.HS512, smpos).compact());
			JSONObject retVal=new JSONObject();
			retVal.put("token",jwt);
			System.out.println("jwt " + jwt);

			return retVal;
		}
		catch (Exception e)
		{
			System.out.println("null je nesto vrv");
			return null;
		}

	}
	
	public String getUserRoleFromToken(String token)
	{
		byte[] encodedBytes = Base64.encodeBase64("smpos".getBytes());
		String key = new String(encodedBytes);
		String role= (String) Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("role");
		return role;
		
	}
	
	public String getUserIdFromToken(String token)
	{
		byte[] encodedBytes = Base64.encodeBase64("smpos".getBytes());
		String key = new String(encodedBytes);
		String id= (String) Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("id");
		System.out.println("ID j e " + id);
		return id;
		
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getOneUserByFirstAndLastName(String firstName,String lastName)
	{
		return userRepository.findByFirstNameAndLastName(firstName, lastName).get(0);
	}



}