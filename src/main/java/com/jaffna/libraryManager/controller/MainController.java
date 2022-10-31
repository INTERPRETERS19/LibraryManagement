package com.jaffna.libraryManager.controller;

import com.jaffna.libraryManager.model.Librarian;
import com.jaffna.libraryManager.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

	@Autowired
	private LibrarianService librarianService;
	
	
	 @GetMapping("/book-view")
	  public String showAll(Model model) {
	      return "book-manager.html";
	  }
	
	 @GetMapping("/member-view")
	  public String showMembers(Model model) {
	      return "member-manager.html";
	  }
	 
	 @GetMapping("/borrowing-view")
	  public String showBorrow(Model model) {
	      return "borrowing-manager.html";
	  }
	 
	
	 
	 @GetMapping("/login")
	    public String login(Model model) {
			  model.addAttribute("librarian", new Librarian());

	        return "login.html";
	    }
		
		
		@PostMapping("/home")
		  public String greetingSubmit(@ModelAttribute Librarian librarian, Model model) {
			    model.addAttribute("librarian", librarian);
			    
			    	if(librarianService.findLibrarian(librarian.getUsername(),librarian.getPassword())) {
			    	
			    	System.out.print("##########"+librarian.getUsername());

				    return "book-manager.html";

			    }
			    return "error.html";

		  }
	
}
