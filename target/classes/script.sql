/* Q1 - Nombre total de votes */
SELECT COUNT(*) AS total_votes FROM vote;

/* Q2 - Nombre de votes par type */
SELECT vote_type, COUNT(*) AS count FROM vote GROUP BY vote_type;

/* Q3 - Nombre de votes valides par candidat */
SELECT
    c.name AS candidate_name,
    COUNT(v.id) AS valid_vote
FROM candidate c
    LEFT JOIN vote v ON c.id = v.candidate_id AND v.vote_type = 'VALID'
GROUP BY c.name;

/* Q4 - Synthèse globale des votes (une seule ligne) */
SELECT
    (SELECT COUNT(*) FROM vote WHERE vote_type = 'VALID') AS valid_count,
    (SELECT COUNT(*) FROM vote WHERE vote_type = 'BLANK') AS blank_count,
    (SELECT COUNT(*) FROM vote WHERE vote_type = 'NULL') AS null_count;
