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

import rs.ac.uns.ftn.models.ProgrIPlanIntProv;
import rs.ac.uns.ftn.services.ProgrIPlanIntProvService;

@RestController
public class Controller extends AbstractRESTController<ProgrIPlanIntProv, String>{

	@Autowired
	Environment environment;
	
	private ProgrIPlanIntProvService pipipService;
	
	public Controller(ProgrIPlanIntProvService pipipService) {
		super(pipipService);
		this.pipipService = pipipService;
	}

	@RequestMapping("/Nikola")
    void sendToHome(HttpServletResponse resp){
		System.out.println("USPIOO:)");	
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(@RequestBody ProgrIPlanIntProv pipip){
		System.out.println("hehehe");
		
		Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		
		pipip.setId(currentTimestamp.toString());
		System.out.println(pipip.getBroj() + " " + currentTimestamp.toString());
		if (pipipService.addProgrIPlanIntProv(pipip)!=null)
			return new ResponseEntity<>(HttpStatus.OK);
		return null;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<ProgrIPlanIntProv> getAll(){
		System.out.println("huhuhu");
		
		return pipipService.getAllProgrIPlanIntProv();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object deleteSelected(@RequestParam(name = "id") String id){
		System.out.println("hohoho");
		System.out.println(id);
		
		if(pipipService.deleteProgrIPlanIntProv(id) != null){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody ProgrIPlanIntProv getSelected(@RequestParam(name = "id") String id){
		System.out.println("hihihi");
		System.out.println(id);
		
		return pipipService.findOne(id);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(@RequestBody ProgrIPlanIntProv pipip){
		System.out.println("hrhrhr");
		
		if (pipipService.update(pipip.getId(), pipip)!=null)
			return new ResponseEntity<>(HttpStatus.OK);
		return null;
	}
	
}
