package rs.ac.uns.ftn.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.models.AuditorOverview;
import rs.ac.uns.ftn.services.AuditorOverviewService;

@RestController
public class AuditorOverviewController extends AbstractRESTController<AuditorOverview, String>{
	

	@Autowired
	Environment environment;
	
	private AuditorOverviewService aOService;
	
	public AuditorOverviewController(AuditorOverviewService aOService) {
		super(aOService);
		this.aOService = aOService;
	}

	@RequestMapping("/Nikola")
    void sendToHome(HttpServletResponse resp){
		System.out.println("USPIOO:)");	
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(@RequestBody AuditorOverview ao){
		System.out.println("hehehe");
		
		ao.setId("auditorOverview");
		System.out.println(ao.getId());
		if (aOService.addAuditorOverview(ao)!=null)
			return new ResponseEntity<>(HttpStatus.OK);
		return null;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public AuditorOverview getAll(){
		System.out.println("huhuhu");
		
		return aOService.findOne("auditorOverview");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(@RequestBody AuditorOverview ao){
		System.out.println("hrhrhr");
		
		if (aOService.update("auditorOverview", ao)!=null)
			return new ResponseEntity<>(HttpStatus.OK);
		return null;
	}

}
