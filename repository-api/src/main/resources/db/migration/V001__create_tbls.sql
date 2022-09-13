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