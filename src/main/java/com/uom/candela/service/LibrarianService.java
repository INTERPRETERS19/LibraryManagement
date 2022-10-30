package com.uom.candela.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uom.candela.model.Librarian;
import com.uom.candela.repository.LibrarianRepository;



@Service
public class LibrarianService {

	@Autowired
	private LibrarianRepository librarianRepository;

	public List<Librarian> getAllLibrarians() {
		List<Librarian> librariansRecords = new ArrayList<>();
		librarianRepository.findAll().forEach(librariansRecords::add);
		return librariansRecords;
	}

	public void addLibrarian(Librarian librarian) {
		librarianRepository.save(librarian);
	}

	public void deleteLibrarian(Librarian librarian) {
		librarianRepository.delete(librarian);
	}	
	
	public void updateLibrarian(Librarian librarian) {
		librarianRepository.save(librarian);
	}
	
	public boolean findLibrarian(String username, String password) {
		
		Optional<Librarian> lib =  librarianRepository.findById(username);
	return lib.get().getPassword().contentEquals(password);
				
	
	}
	
}
