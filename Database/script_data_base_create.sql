CREATE TABLE repository.tag (
	id_tag BIGSERIAL NOT NULL PRIMARY KEY,
	tag VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE repository.user_type (
	id_user_type BIGSERIAL NOT NULL PRIMARY KEY,
	user_type VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE repository.kind_of_work (
	id_kind_of_work BIGSERIAL NOT NULL PRIMARY KEY,
	kind_of_work VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE repository.summary (
	id_summary BIGSERIAL NOT NULL PRIMARY KEY,
	summary TEXT NOT NULL
);

CREATE TABLE repository.course (
	id_course BIGSERIAL NOT NULL PRIMARY KEY,
	course VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE repository.file_path (
	id_file_path BIGSERIAL NOT NULL PRIMARY KEY,
	file_path VARCHAR(200) NOT NULL UNIQUE
);

CREATE TABLE repository.subject (
	id_subject BIGSERIAL NOT NULL PRIMARY KEY,
	subject_code VARCHAR(5) NOT NULL UNIQUE,
	subject VARCHAR(200) NOT NULL
);
---------------------------------------------------------
CREATE TABLE repository.user (
	id_user BIGSERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(150) NOT NULL,
	created_at TIMESTAMPTZ DEFAULT NOW(),
	last_acess TIMESTAMPTZ,
	email VARCHAR(150) NOT NULL UNIQUE,
	registration BIGINT NOT NULL UNIQUE,
	password VARCHAR(50) NOT NULL,
	id_user_type BIGSERIAL NOT NULL REFERENCES repository.user_type
);
---------------------------------------------------------
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
	year_application VARCHAR(9) NOT NULL,
	created_at TIMESTAMPTZ DEFAULT NOW(),
	modified_in TIMESTAMPTZ,
	id_subject BIGSERIAL NOT NULL REFERENCES repository.subject,
	id_kind_of_work BIGSERIAL NOT NULL REFERENCES repository.kind_of_work,
	id_user BIGSERIAL NOT NULL REFERENCES repository.user,
	id_file_path BIGSERIAL NOT NULL REFERENCES repository.file_path
);
---------------------------------------------------------
CREATE TABLE repository.final_paper_has_tag (
	id_final_paper BIGSERIAL NOT NULL REFERENCES repository.final_paper,
	id_tag BIGSERIAL NOT NULL REFERENCES repository.tag
);
---------------------------------------------------------