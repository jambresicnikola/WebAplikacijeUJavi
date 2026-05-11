DROP TABLE IF EXISTS achievement;
DROP TABLE IF EXISTS platform;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS game;

CREATE TABLE IF NOT EXISTS game (
                                    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    title              VARCHAR(255) NOT NULL,
                                    platform           VARCHAR(100) NOT NULL,
                                    developer          VARCHAR(255) NOT NULL,
                                    release_year       INT          NOT NULL,
                                    total_achievements INT          NOT NULL
);

CREATE TABLE IF NOT EXISTS review (
                                      id      BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      author  VARCHAR(100) NOT NULL,
                                      content VARCHAR(500) NOT NULL,
                                      rating  INT,
                                      game_id BIGINT,
                                      FOREIGN KEY (game_id) REFERENCES game(id)
);

CREATE TABLE IF NOT EXISTS achievement (
                                           id          BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           game_id     BIGINT,
                                           name        VARCHAR(200),
                                           description VARCHAR(500),
                                           points      INT,
                                           is_secret   BOOLEAN,
                                           category    VARCHAR(50),
                                           FOREIGN KEY (game_id) REFERENCES game(id)
);

CREATE TABLE IF NOT EXISTS platform (
                                        id           BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name         VARCHAR(100) NOT NULL,
                                        manufacturer VARCHAR(100),
                                        release_year INT,
                                        game_id      BIGINT,
                                        FOREIGN KEY (game_id) REFERENCES game(id)
);