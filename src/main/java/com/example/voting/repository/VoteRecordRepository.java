package com.example.voting.repository;

import com.example.voting.models.VoteItem;
import com.example.voting.models.VoteRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRecordRepository extends JpaRepository<VoteRecord, Long> {
    long countByVoteItem(VoteItem voteItem);
}
