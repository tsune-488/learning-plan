CREATE TABLE teachers (
	id SERIAL PRIMARY KEY,
	schoolname VARCHAR(25) NOT NULL,
	email VARCHAR(60) NOT NULL,
	password VARCHAR(255) NOT NULL,
	classname VARCHAR(10) NOT NULL,
	teachername VARCHAR(10) NOT NULL
);

CREATE TABLE tests (
	id SERIAL PRIMARY KEY,
	teacher_id INT NOT NULL,
	testname VARCHAR(25) NOT NULL,
	startday DATE NOT NULL,
	lastday DATE NOT NULL,
	FOREIGN KEY (teacher_id) REFERENCES teachers(id) ON DELETE CASCADE
);

CREATE TABLE students (
	id SERIAL PRIMARY KEY,
	teacher_id INT NOT NULL,
	test_id INT NOT NULL,
	studentnumber VARCHAR(10) NOT NULL,
	studentname VARCHAR(20) NOT NULL,
	studentpassword VARCHAR(255) NOT NULL,
	UNIQUE (studentnumber, test_id),
	FOREIGN KEY (teacher_id) REFERENCES teachers(id) ON DELETE CASCADE,
	FOREIGN KEY (test_id) REFERENCES tests(id) ON DELETE CASCADE
);

CREATE TABLE learning_records (
	id SERIAL PRIMARY KEY,
	student_id INT NOT NULL,
	test_id INT NOT NULL,
	learn_day DATE NOT NULL,
	plan VARCHAR(255),
	record VARCHAR(255),
	UNIQUE (student_id, test_id, learn_day),
	FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
	FOREIGN KEY (test_id) REFERENCES tests(id) ON DELETE CASCADE
);