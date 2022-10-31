package com.uom.candela.repository;

import com.uom.candela.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, String> {
    Optional<Borrowing> findFirstByBookIdAndMemberId(String bookId, String memberId);
}
