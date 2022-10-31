package com.jaffna.libraryManager.repository;

import com.jaffna.libraryManager.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, String> {
    Optional<Borrowing> findFirstByBookIdAndMemberId(String bookId, String memberId);
}
