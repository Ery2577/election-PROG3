INSERT INTO candidate (id, name) VALUES
                                 (1,'Alice'),
                                 (2,'Bob'),
                                 (3, 'Charlie');
INSERT INTO voter (id, name) VALUES
                             (1,'Voter1'),
                             (2, 'Voter2'),
                             (3, 'Voter3'),
                             (4, 'Voter4'),
                             (5, 'Voter5'),
                             (6, 'Voter6');
INSERT INTO vote (id, candidate_id, voter_id, vote_type) VALUES
                                                         (1, 1, 1, 'VALID'),
                                                         (2, 1, 2, 'VALID'),
                                                         (3, 2, 3, 'VALID'),
                                                         (4, 2, 4, 'BLANK'),
                                                         (5, NULL, 5, 'BLANK'),
                                                         (6, 3, 6, 'NULL');