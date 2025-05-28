WITH SessionCounts AS (
    SELECT
        event_id,
        COUNT(session_id) AS session_count
    FROM Sessions
    GROUP BY event_id
)

SELECT
    e.event_id,
    e.title,
    sc.session_count
FROM SessionCounts sc
JOIN Events e ON sc.event_id = e.event_id
WHERE sc.session_count = (
    SELECT MAX(session_count) FROM SessionCounts
);
