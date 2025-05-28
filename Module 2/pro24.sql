SELECT
    event_id,
    AVG(TIMESTAMPDIFF(MINUTE, start_time, end_time)) AS average_session_duration_minutes
FROM Sessions
GROUP BY event_id;
