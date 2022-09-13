CREATE TABLE repository.final_paper_has_tag (
	id_final_paper BIGSERIAL NOT NULL REFERENCES repository.final_paper,
	id_tag BIGSERIAL NOT NULL REFERENCES repository.tag
);