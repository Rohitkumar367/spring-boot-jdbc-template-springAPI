CREATE table if not exists employees (
    id INT PRIMARY KEY auto_increment,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    salary double NOT NULL
);

CREATE TABLE if not exists student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT,
    department VARCHAR(50),
    phone VARCHAR(15)
);

CREATE TABLE if not exists attendance (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    attendance_date DATE NOT NULL,
    status VARCHAR(10) NOT NULL,

    CONSTRAINT fk_attendance_student
    FOREIGN KEY (student_id)
    REFERENCES student(id)
    ON DELETE CASCADE
);

CREATE TABLE if not exists marks (
    marks_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    subject VARCHAR(50) NOT NULL,
    marks INT NOT NULL,
    semester INT NOT NULL,

    CONSTRAINT fk_marks_student
    FOREIGN KEY (student_id)
    REFERENCES student(id)
    ON DELETE CASCADE
);