insert into employees (name, department, salary) values ('John Doe', 'Engineering', 75000);
insert into employees (name, department, salary) values ('Jane Smith', 'Marketing', 65000);
insert into employees (name, department, salary) values ('Alice Johnson', 'Sales', 70000);
insert into employees (name, department, salary) values ('Bob Brown', 'Engineering', 80000);
insert into employees (name, department, salary) values ('Charlie Davis', 'HR', 60000);


INSERT INTO student (name, email, age, department, phone)
VALUES
('Alice Johnson', 'alice@gmail.com', 20, 'CSE', '9876543210'),
('Bob Smith', 'bob@gmail.com', 21, 'ECE', '9876543211'),
('Charlie Brown', 'charlie@gmail.com', 22, 'IT', '9876543212'),
('David Wilson', 'david@gmail.com', 20, 'ME', '9876543213');


INSERT INTO attendance (student_id, attendance_date, status)
VALUES
(1, '2026-07-25', 'Present'),
(2, '2026-07-25', 'Absent'),
(3, '2026-07-25', 'Present'),
(4, '2026-07-25', 'Present');


INSERT INTO attendance (student_id, attendance_date, status)
VALUES
(1, '2026-07-26', 'Absent'),
(2, '2026-07-26', 'Present'),
(3, '2026-07-26', 'Present'),
(4, '2026-07-26', 'Absent');


INSERT INTO marks (student_id, subject, marks, semester)
VALUES
(1, 'Java', 92, 5),
(2, 'Java', 78, 5),
(3, 'Java', 85, 5),
(4, 'Java', 90, 5);


INSERT INTO marks (student_id, subject, marks, semester)
VALUES
(1, 'DBMS', 88, 5),
(2, 'DBMS', 81, 5),
(3, 'DBMS', 95, 5),
(4, 'DBMS', 84, 5);