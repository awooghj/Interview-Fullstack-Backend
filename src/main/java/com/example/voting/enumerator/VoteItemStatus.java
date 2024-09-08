package com.example.voting.enumerator;

public enum VoteItemStatus {
    ACTIVE(1),
    DEACTIVE(0);

    private final int value;

    VoteItemStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static VoteItemStatus fromValue(int value) {
        for (VoteItemStatus status : VoteItemStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}