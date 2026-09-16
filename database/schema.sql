-- DROP DATABASE jobflow;

CREATE DATABASE jobflow;
USE jobflow;

CREATE TABLE job_application (
    id INT PRIMARY KEY AUTO_INCREMENT,
    company VARCHAR(150) NOT NULL,
    position VARCHAR(150) NOT NULL,
    job_url VARCHAR(500),
    location VARCHAR(150),
    modality VARCHAR(50),
    status VARCHAR(50) NOT NULL,
    applied_date DATE,
    notes TEXT,
    created_at DATETIME,
    updated_at DATETIME
);

CREATE TABLE technologies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL UNIQUE
);

CREATE TABLE job_application_technologies (
    job_application_id INT,
    technology_id INT,

    FOREIGN KEY (job_application_id) REFERENCES job_application(id),

    FOREIGN KEY (technology_id) REFERENCES technologies(id)
);

INSERT INTO job_application (company, position, modality, status, applied_date)
VALUES
('DXC', 'Java Junior', 'REMOTE', 'APPLIED', '2026-09-16'),
('EMALSA', 'Frontend Developer', 'HYBRID', 'APPLIED', '2026-09-01'),
('EMALSA', 'Java Junior', 'ON_SITE', 'APPLIED', '2026-09-05');

INSERT INTO technologies (name) VALUES ('Java'), ('Spring Boot'), ('SQL');

INSERT INTO job_application_technologies (job_application_id, technology_id) VALUES (1, 1);

SELECT * FROM technologies;

SELECT ja.company, ja.position, t.name FROM job_application ja
JOIN job_application_technologies jat ON ja.id = jat.job_application_id
JOIN technologies t ON jat.technology_id = t.id;

SELECT * FROM job_application WHERE LOWER(status) = LOWER('INTERVIEW');

SELECT * FROM job_application WHERE LOWER(position) LIKE '%java%';

SELECT * FROM job_application ORDER BY applied_date ASC;

SELECT status, COUNT(*) FROM job_application GROUP BY status;
SELECT * FROM job_application;



