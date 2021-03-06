package rs.ac.uns.ftn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@RequestMapping("/")
    void sendToHome(HttpServletResponse resp){
        try {
            resp.sendRedirect("/SMPuOS");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/SMPuOS")
    void home(HttpServletRequest req, HttpServletResponse resp){
        try {
        	System.out.println("SmPUos");
            //RequestDispatcher rd = req.getRequestDispatcher("http://www.google.com");
        	RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.forward(req, resp);
            //resp.sendRedirect("http://localhost:8085/smpuos/SMPuOS/home");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
}
	

}
