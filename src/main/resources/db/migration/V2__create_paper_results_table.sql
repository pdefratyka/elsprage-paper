CREATE TABLE elsprage_paper.paper_results
(
    id serial NOT NULL,
    user_id integer NOT NULL,
    topic_id integer NOT NULL,
    paper_mode_id integer NOT NULL,
    language varchar(100) NOT NULL,
    paper_text varchar(50000) NOT NULL,
    refactored_text varchar(50000),
    date timestamp NOT NULL,
    score decimal,
    time varchar(20),
    PRIMARY KEY (id)
);

CREATE TABLE elsprage_paper.paper_errors
(
    id serial NOT NULL,
    result_id integer NOT NULL,
    wrong varchar(400) NOT NULL,
    corrected varchar(400),
    explanation varchar(400),
    error_level varchar(30)
);

CREATE TABLE elsprage_paper.paper_mode
(
    id serial NOT NULL,
    name varchar(100) NOT NULL,
    number_of_words integer NOT NULL,
    duration_in_minutes integer NOT NULL
);

INSERT INTO elsprage_paper.paper_mode(id, name, number_of_words, duration_in_minutes) values (1, 'SHORT', 200, 10);
INSERT INTO elsprage_paper.paper_mode(id, name, number_of_words, duration_in_minutes) values (2, 'MEDIUM', 500, 30);
INSERT INTO elsprage_paper.paper_mode(id, name, number_of_words, duration_in_minutes) values (3, 'LONG', 1000, 60);