CREATE TABLE IF NOT EXISTS game (
                                    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    title            VARCHAR(255) NOT NULL,
    platform         VARCHAR(100) NOT NULL,
    developer        VARCHAR(255) NOT NULL,
    release_year     INT          NOT NULL,
    total_achievements INT        NOT NULL
    );