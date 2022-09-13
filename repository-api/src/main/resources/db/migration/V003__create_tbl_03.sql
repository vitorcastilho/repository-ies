CREATE TABLE repository.final_paper (
	id_final_paper BIGSERIAL NOT NULL PRIMARY KEY,
	title VARCHAR(200) NOT NULL,
	author VARCHAR(150) NOT NULL,
	year INTEGER NOT NULL,
	semester INTEGER NOT NULL,
	created_at TIMESTAMPTZ DEFAULT NOW(),
	modified_in TIMESTAMPTZ,
	is_public BOOLEAN NOT NULL,
	id_summary BIGSERIAL NOT NULL REFERENCES repository.summary,
	id_course BIGSERIAL NOT NULL REFERENCES repository.course,
	id_user BIGSERIAL NOT NULL REFERENCES repository.user,
	id_file_path BIGSERIAL NOT NULL REFERENCES repository.file_path
);

CREATE TABLE repository.work (
	id_work BIGSERIAL NOT NULL PRIMARY KEY,
	year_application INTEGER NOT NULL,
	created_at TIMESTAMPTZ DEFAULT NOW(),
	modified_in TIMESTAMPTZ,
	id_subject BIGSERIAL NOT NULL REFERENCES repository.subject,
	id_kind_of_work BIGSERIAL NOT NULL REFERENCES repository.kind_of_work,
	id_user BIGSERIAL NOT NULL REFERENCES repository.user,
	id_file_path BIGSERIAL NOT NULL REFERENCES repository.file_path
);