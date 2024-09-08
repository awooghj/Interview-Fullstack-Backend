package com.example.voting.repository;

import com.example.voting.models.VoteItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VoteItemRepository extends JpaRepository<VoteItem, Long> {
    List<VoteItem> findByStatus(int status);

    VoteItem findByIdAndStatus(Long id, int status);
}