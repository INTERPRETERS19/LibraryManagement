package com.uom.candela.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
