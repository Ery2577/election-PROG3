/*Q1 - Nombre total de votes*/
SELECT COUNT(*) AS total_votes FROM vote;

/*Q2 - Nombre de votes par type*/
SELECT vote_type, COUNT(*) AS count FROM vote GROUP BY vote_type