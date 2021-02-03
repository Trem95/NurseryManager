use nurserydb;
CREATE TABLE baby (
                      baby_id INT AUTO_INCREMENT,
                      baby_name VARCHAR(50) NOT NULL,
                      CONSTRAINT PK_baby_id PRIMARY KEY (baby_id)
);

CREATE TABLE observation (
                             observation_id INT AUTO_INCREMENT,
                             observation_author VARCHAR(20) NOT NULL,
                             observation TINYTEXT,
                             baby_id INT NOT NULL,
                             observation_date DATE NOT NULL,
                             observation_time TIME NOT NULL,
                             CONSTRAINT PK_observation_id PRIMARY KEY (observation_id),
                             CONSTRAINT FK_observation_baby_id FOREIGN KEY (baby_id)
                                 REFERENCES baby (baby_id)
);

CREATE TABLE timesheet (
                           timesheet_id INT AUTO_INCREMENT,
                           timesheet_date DATE NOT NULL,
                           arrival_time TIME NOT NULL,
                           leave_time TIME,
                           baby_id INT NOT NULL,
                           CONSTRAINT PK_timesheet_id PRIMARY KEY (timesheet_id),
                           CONSTRAINT FK_timesheet_baby_id FOREIGN KEY (baby_id)
                               REFERENCES baby (baby_id)
);

CREATE TABLE nap (
                     nap_id INT AUTO_INCREMENT,
                     nap_date DATE NOT NULL,
                     nap_time_begin TIME NOT NULL,
                     nap_time_end TIME NOT NULL,
                     nap_obs TINYTEXT,
                     baby_id INT NOT NULL,
                     CONSTRAINT PK_nap_id PRIMARY KEY (nap_id),
                     CONSTRAINT FK_nap_baby_id FOREIGN KEY (baby_id)
                         REFERENCES baby (baby_id)
);

CREATE TABLE meal (
                      meal_id INT AUTO_INCREMENT,
                      baby_id INT NOT NULL,
                      type_meal VARCHAR(50) NOT NULL,
                      meal_obs TINYTEXT,
                      meal_date DATE NOT NULL,
                      meal_time TIME NOT NULL,
                      CONSTRAINT PK_nap_id PRIMARY KEY (meal_id),
                      CONSTRAINT FK_meal_baby_id FOREIGN KEY (baby_id)
                          REFERENCES baby (baby_id)
);

CREATE TABLE paednurse (
                           paednurse_id INT AUTO_INCREMENT,
                           name VARCHAR(50) NOT NULL,
                           login VARCHAR(50) NOT NULL,
                           pwd VARCHAR(100) NOT NULL,
                           CONSTRAINT PK_paednurse_id PRIMARY KEY (paednurse_id)
);