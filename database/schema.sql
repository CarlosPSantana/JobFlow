/*DROP DATABASE jobFlow;*/
CREATE DATABASE jobFlow;

USE jobFlow;

CREATE TABLE job_application(
    id INT PRIMARY KEY AUTO_INCREMENT,
    company VARCHAR(150) NOT NULL,
    position VARCHAR(150) NOT NULL,
    job_url varchar(500),
    location VARCHAR(150),
    modality VARCHAR(50),
    status VARCHAR(50) NOT NULL,
    applied_date DATE,
    notes TEXT,
    created_at DATETIME,
    updated_at DATETIME

);

CREATE TABLE technologies(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(150) NOT NULL UNIQUE
);

CREATE TABLE job_application_technologies(
    job_application_id INT,
    technologies_id INT,

    FOREIGN KEY (job_application_id) REFERENCES job_application(id),
    FOREIGN KEY (technologies_id) REFERENCES technologies(id)
);


INSERT INTO job_application(company, position, modality, status, applied_date) VALUES ('DXC', 'Java Junior', 'REMOTE', 'APPLIED','2026-09-16');
INSERT INTO job_application(company, position, modality, status, applied_date) VALUES ('EMALSA', 'Frontend Developer', 'Hybrid', 'APPLIED','2026-09-1');
INSERT INTO job_application(company, position, modality, status, applied_date) VALUES ('EMALSA', 'Java Junior', 'REMOTE', 'PRESENTIAL','2026-09-5');
INSERT INTO technologies (name)VALUES ('Java'), ('Spring Boot'), ('SQL');
INSERT INTO job_application_technologies (job_application_id, technologies_id) VALUES (1, 1);

#SELECT * FROM job_application WHERE status = 'APPLIED';
#SELECT * FROM job_application WHERE company = 'EMALSA' AND position = 'Frontend Developer';
#SELECT * FROM job_application ORDER BY applied_date ASC;

#SELECT * FROM job_application WHERE LOWER(company) = LOWER('DXC');
#SELECT * FROM job_application WHERE LOWER(position) LIKE '%java%'; 

SELECT * FROM technologies;

SELECT ja.company, ja.position, t.name FROM job_application ja
JOIN job_application_technologies jat ON ja.id = jat.job_application_id
JOIN technologies t ON jat.technologies_id = t.id;

SELECT * FROM job_application WHERE LOWER(status) = LOWER('INTERVIEW');
SELECT * FROM job_application WHERE LOWER(position) LIKE '%java%'; 
SELECT * FROM job_application ORDER BY applied_date ASC;
SELECT status, COUNT(*) FROM job_application GROUP BY status;



