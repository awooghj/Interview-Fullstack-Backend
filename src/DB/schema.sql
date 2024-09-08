CREATE TABLE vote_item (
    id SERIAL PRIMARY KEY,       -- Automatically generated ID
    name VARCHAR(255) NOT NULL   -- Name of the voting item
);

CREATE TABLE vote_record (
    id SERIAL PRIMARY KEY,          -- Automatically generated ID
    voter VARCHAR(255) NOT NULL,    -- Name of the voter
    vote_item_id INT NOT NULL,      -- Foreign key referencing the VoteItem table
    FOREIGN KEY (vote_item_id) REFERENCES vote_item(id)
);
