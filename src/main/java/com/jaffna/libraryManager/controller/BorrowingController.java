package com.jaffna.libraryManager.controller;

import com.jaffna.libraryManager.dto.BorrowRequestDTO;
import com.jaffna.libraryManager.dto.BorrowingDTO;
import com.jaffna.libraryManager.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/borrowings")
public class BorrowingController {
    @Autowired
    private BorrowingService borrowingService;

    @GetMapping
    public ResponseEntity<List<BorrowingDTO>> getBorrowings() {
        return ResponseEntity.ok(borrowingService.getBorrowings());
    }

    @PostMapping
    public ResponseEntity<BorrowingDTO> borrowBook(@RequestBody BorrowRequestDTO borrowRequestDTO) throws Exception {
        BorrowingDTO borrowingDTO = borrowingService.borrow(borrowRequestDTO);
        return ResponseEntity.ok(borrowingDTO);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<BorrowingDTO> updateborrowBook(@PathVariable("id") String borrowId, @RequestBody BorrowRequestDTO borrowRequestDTO) throws Exception {        
        return ResponseEntity.ok(borrowingService.updateBorrow(borrowId,borrowRequestDTO));
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") String borrowId) {
    	borrowingService.deleteBorrowingById(borrowId);
        return ResponseEntity.ok().build();
    }

   
}
