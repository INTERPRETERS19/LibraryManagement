package com.uom.candela.controller;

import com.uom.candela.dto.BookDTO;
import com.uom.candela.dto.BorrowRequestDTO;
import com.uom.candela.dto.BorrowingDTO;
import com.uom.candela.dto.MemberDTO;
import com.uom.candela.service.BookService;
import com.uom.candela.service.BorrowingService;
import com.uom.candela.service.MemberService;
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
