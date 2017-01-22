package rs.ac.uns.ftn.controllers;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.models.ObavOIntProv;
import rs.ac.uns.ftn.services.ObavOIntProvService;

@RestController
public class NotificationController extends AbstractRESTController<ObavOIntProv, String>{
	
	@Autowired
	Environment environment;
	
	private ObavOIntProvService oIPService;
	
	public NotificationController(ObavOIntProvService oIPService) {
		super(oIPService);
		this.oIPService = oIPService;
	}

	@RequestMapping("/Nikola")
    void sendToHome(HttpServletResponse resp){
		System.out.println("USPIOO:)");	
    }

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(@RequestBody ObavOIntProv oIP){
		System.out.println("hehehe");
		
		Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		
		oIP.setId(currentTimestamp.toString());
		System.out.println(oIP.getId() + " " + currentTimestamp.toString());
		if (oIPService.addProgrIPlanIntProv(oIP)!=null)
			return new ResponseEntity<>(HttpStatus.OK);
		return null;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<ObavOIntProv> getAll(){
		System.out.println("huhuhu");
		
		return oIPService.getAllProgrIPlanIntProv();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object deleteSelected(@RequestParam(name = "id") String id){
		System.out.println("hohoho");
		System.out.println(id);
		
		if(oIPService.deleteProgrIPlanIntProv(id) != null){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody ObavOIntProv getSelected(@RequestParam(name = "id") String id){
		System.out.println("hihihi");
		System.out.println(id);
		
		return oIPService.findOne(id);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(@RequestBody ObavOIntProv oIP){
		System.out.println("hrhrhr");
		
		if (oIPService.update(oIP.getId(), oIP)!=null)
			return new ResponseEntity<>(HttpStatus.OK);
		return null;
	}
	
}
