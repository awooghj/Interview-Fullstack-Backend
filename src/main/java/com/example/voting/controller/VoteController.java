package com.example.voting.controller;

import com.example.voting.models.VoteItem;
import com.example.voting.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/votes")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @GetMapping("/items")
    public List<VoteItem> getAllVoteItems() {
        return voteService.getAllVoteItems();
    }

    @GetMapping("/items/{voteId}")
    public VoteItem getSingleVoteItem(@PathVariable("voteId") String voteId) {
        return voteService.getSingleVote(voteId);
    }

    @PostMapping("/items/{voteId}")
    public void deleteSingleVoteItem(@PathVariable("voteId") String voteId) {
        voteService.deactivateVoteItem(voteId);
    }

    @PostMapping("/items")
    public VoteItem addVoteItem(@RequestParam String name) {
        return voteService.addVoteItem(name);
    }

    @PostMapping("/support")
    public void supportVote(@RequestParam String voterName, @RequestParam String voteId) {
        voteService.vote(voterName, voteId);
    }

    @GetMapping("/results")
    public Map<String, Long> getVoteResults() {
        return voteService.getVoteResults();
    }
}
