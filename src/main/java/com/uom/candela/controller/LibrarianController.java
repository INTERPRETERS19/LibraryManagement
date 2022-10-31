package com.uom.candela.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.uom.candela.model.Librarian;
import com.uom.candela.service.LibrarianService;


@RestController
public class LibrarianController {

	@Autowired
	private LibrarianService librarianService;
	
	@RequestMapping(value="/add-librarian", method=RequestMethod.POST)    
	public void addUser(@RequestBody Librarian Librarian)  
	{  
		librarianService.addLibrarian(Librarian);
		
	}
//	@RequestMapping(value="/logout", method=RequestMethod.GET)
//	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null){
//			new SecurityContextLogoutHandler().logout(request, response, auth);
//		}
//		return "redirect:/";
//	}


}
