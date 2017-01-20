package rs.uns.ac.rs.services;


import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

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

	public JSONObject getTokenForUser(User user)
	{
		try{
			byte[] encodedBytes = Base64.encodeBase64("smpos".getBytes());
			String smpos = new String(encodedBytes);
			JSONObject payload = new JSONObject();
			payload.put("firstName", user.getFirstName());
			payload.put("lastName",user.getLastName());
			payload.put("role", user.getRole());
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
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}



}