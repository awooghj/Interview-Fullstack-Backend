package com.example.voting.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class VoteRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String voter;

    @ManyToOne
    @JoinColumn(name = "vote_item_id")
    @JsonBackReference
    private VoteItem voteItem;

    public VoteRecord() {
    }

    public VoteRecord(String voter, VoteItem voteItem) {
        this.voter = voter;
        this.voteItem = voteItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    public VoteItem getVoteItem() {
        return voteItem;
    }

    public void setVoteItem(VoteItem voteItem) {
        this.voteItem = voteItem;
    }
}