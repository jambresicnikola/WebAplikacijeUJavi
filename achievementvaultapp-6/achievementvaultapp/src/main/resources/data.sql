INSERT INTO game (title, platform, developer, release_year, total_achievements)
VALUES ('The Witcher 3', 'PC', 'CD Projekt Red', 2015, 78),
       ('Elden Ring', 'PlayStation 5', 'FromSoftware', 2022, 42),
       ('Hades', 'PC', 'Supergiant Games', 2020, 50),
       ('God of War Ragnarok', 'PlayStation 5', 'Santa Monica Studio', 2022, 36),
       ('Cyberpunk 2077', 'PC', 'CD Projekt Red', 2020, 44),
       ('Stardew Valley', 'PC', 'ConcernedApe', 2016, 40),
       ('Red Dead Redemption 2', 'Xbox One', 'Rockstar Games', 2018, 51),
       ('Hollow Knight', 'PC', 'Team Cherry', 2017, 63);

INSERT INTO achievement (game_id, name, description, points, is_secret, category)
VALUES (1, 'First Blood', 'Pobijedi prvog neprijatelja', 10, false, 'Combat'),
       (1, 'Speedrunner', 'Dovrsi za manje od 2h', 50, true, 'Challenge'),
       (2, 'Elden Lord', 'Dovrsi igru', 100, false, 'Story');

INSERT INTO platform (name, manufacturer, release_year, game_id)
VALUES ('PC', 'Various', 2015, 1),
       ('PlayStation 4', 'Sony', 2013, 1),
       ('PlayStation 5', 'Sony', 2020, 2),
       ('Xbox Series X', 'Microsoft', 2020, 2),
       ('PC', 'Various', 2018, 3);

INSERT INTO review (author, content, rating, game_id)
VALUES ('Ivan', 'Odlična igra, preporučam svima!', 5, 1),
       ('Marko', 'Malo teška ali super.', 4, 1),
       ('Ana', 'Previše teško za mene.', 3, 2),
       ('Luka', 'Najbolja priča ikada ispričana.', 5, 4),
       ('Petra', 'Nakon svih updateova, igra je fenomenalna.', 5, 5),
       ('Dino', 'Jako opuštajuće, igram svaki dan.', 4, 6),
       ('Marija', 'Svijet je predivan, ali kretanje je malo sporo.', 4, 7),
       ('Filip', 'Preteško, ali atmosfera je 10/10.', 5, 8);