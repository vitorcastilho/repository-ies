CREATE TABLE repository.final_paper_has_tag (
	id_final_paper BIGSERIAL NOT NULL REFERENCES repository.final_paper,
	id_tag BIGSERIAL NOT NULL REFERENCES repository.tag
);

CREATE TABLE repository.user_has_user_type (
	id_user BIGSERIAL NOT NULL REFERENCES repository.user,
	id_user_type BIGSERIAL NOT NULL REFERENCES repository.user_type
);