-- Drop existing stored procedure for finding vote items by status, if it exists
DROP PROCEDURE IF EXISTS find_vote_items_by_status$$
CREATE PROCEDURE find_vote_items_by_status(IN status_in INT)
BEGIN
    -- Select all vote items where the status matches the input parameter
    SELECT * FROM vote_item WHERE status = status_in ORDER BY id;
END$$

-- Drop existing stored procedure for finding a vote item by both ID and status, if it exists
DROP PROCEDURE IF EXISTS find_vote_item_by_id_and_status$$
CREATE PROCEDURE find_vote_item_by_id_and_status(IN id_in BIGINT, IN status_in INT)
BEGIN
    -- Select a vote item where both the id and status match the input parameters
    SELECT * FROM vote_item WHERE id = id_in AND status = status_in;
END$$

-- Reset the delimiter back to the default
DELIMITER ;
