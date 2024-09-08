package com.example.voting.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class VoteItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "voteItem")
    @JsonManagedReference
    private List<VoteRecord> voteRecords;

    @Column(name = "status", nullable = false)
    private int status = 1;

    public VoteItem() {
    }

    public VoteItem(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VoteRecord> getVoteRecords() {
        return voteRecords;
    }

    public void setVoteRecords(List<VoteRecord> voteRecords) {
        this.voteRecords = voteRecords;
    }

    public void deactivate() {
        this.status = 0;
    }

    public void activate() {
        this.status = 1;
    }
}