package com.example.demo.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SesscionService {

	  @Autowired
	    private HttpSession session;
	  
	  @Autowired
	    private HttpServletRequest request;

	  public void setvalue(String name , Object object)
	  {
		  session.setAttribute(name, object);
	  }
	  
	  public <T> T getValue(String name)
	  {
		  return (T) session.getAttribute(name);
	  }
	 
	  public void removeValue(String name)
	  {
		  session.removeAttribute(name);
	  }
	  
	  public void setValuevip(String name, Object object) {
	        HttpSession session = request.getSession();
	        if (session != null) {
	            session.setAttribute(name, object);
	        } else {
	            // Handle the case when session is null
	            throw new IllegalStateException("Session could not be created.");
	        }
	    }
	  
}
