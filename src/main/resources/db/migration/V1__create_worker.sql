CREATE TABLE IF NOT EXISTS worker (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL,
                            workstation VARCHAR(100),
                            last_assignment DATE,
                            skill VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS place (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR(100) NOT NULL,
                              location VARCHAR(100),
                              worker_id INT REFERENCES worker(id) ON DELETE SET NULL,
                              assignment_date DATE,
                              required_skill VARCHAR(100)
    );
