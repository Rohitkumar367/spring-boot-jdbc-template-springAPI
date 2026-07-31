CREATE table if not exists employees (
    id INT PRIMARY KEY auto_increment,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    salary double NOT NULL,
);