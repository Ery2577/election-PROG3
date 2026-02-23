/*Q1 - Nombre total de votes*/
SELECT COUNT(*) AS total_votes
FROM vote
group by vote_type;

/*Q2 - Nombre de votes par type*/
