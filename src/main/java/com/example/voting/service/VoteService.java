package com.example.voting.service;

import com.example.voting.enumerator.VoteItemStatus;
import com.example.voting.models.VoteItem;
import com.example.voting.models.VoteRecord;
import com.example.voting.repository.VoteItemRepository;
import com.example.voting.repository.VoteRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VoteService {
    @Autowired
    private VoteItemRepository voteItemRepository;
    @Autowired
    private VoteRecordRepository voteRecordRepository;

    @Transactional
    public VoteItem addVoteItem(String name) {
        return voteItemRepository.save(new VoteItem(name));
    }

    public List<VoteItem> getAllVoteItems() {
        return voteItemRepository.findByStatus(VoteItemStatus.ACTIVE.getValue());
    }

    public VoteItem getSingleVote(String voteId) {
        return voteItemRepository.findByIdAndStatus(Long.parseLong(voteId), VoteItemStatus.ACTIVE.getValue());
    }

    public void deactivateVoteItem(String id) {
        Optional<VoteItem> voteItemOpt = voteItemRepository.findById(Long.parseLong(id));
        if (voteItemOpt.isPresent()) {
            VoteItem voteItem = voteItemOpt.get();
            voteItem.deactivate();
            voteItemRepository.save(voteItem); // Save the deactivated vote item
        }
    }

    @Transactional
    public void vote(String voterName, String voteItemId) {
            VoteItem voteItem = voteItemRepository.findByIdAndStatus(Long.parseLong(voteItemId), VoteItemStatus.ACTIVE.getValue());
            VoteRecord voteRecord = new VoteRecord(voterName, voteItem);
            voteRecordRepository.save(voteRecord);

    }

    public Map<String, Long> getVoteResults() {
        List<VoteItem> items = voteItemRepository.findAll();
        Map<String, Long> results = new HashMap<>();
        for (VoteItem item : items) {
            Long count = voteRecordRepository.countByVoteItem(item);
            results.put(item.getName(), count);
        }
        return results;
    }
}

