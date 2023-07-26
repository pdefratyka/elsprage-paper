CREATE TABLE elsprage_paper.topics
(
    id serial NOT NULL,
    value varchar(600) NOT NULL,
    user_id integer NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE elsprage_paper.topics ADD CONSTRAINT unique_topic_value UNIQUE (value);

CREATE TABLE elsprage_paper.tags
(
    id serial NOT NULL,
    value varchar(150) NOT NULL,
    user_id integer NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE elsprage_paper.tags ADD CONSTRAINT unique_tag_value UNIQUE (value);

CREATE TABLE elsprage_paper.topics_tags
(
    topic_id serial NOT NULL,
    tag_id serial NOT NULL
);

