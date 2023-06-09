DROP TABLE IF EXISTS task, employee, team, project, employee_in_team;

CREATE TABLE IF NOT EXISTS employee
(
    id serial PRIMARY KEY,
    firstname character varying(50) NOT NULL,
    lastname character varying(50) NOT NULL,
    fathername character varying(50),
    position character varying(50),
    account character varying(50) UNIQUE,
    email character varying(50) NOT NULL,
    status character varying(30) NOT NULL,
    password character varying(50) NOT NULL,
    is_temporary_pwd bool NOT NULL
);

CREATE TABLE IF NOT EXISTS team
(
    id serial PRIMARY KEY,
    name character varying(50)
);

CREATE TABLE IF NOT EXISTS project
(
    id serial PRIMARY KEY,
    fk_team int,
    code character varying(30) NOT NULL UNIQUE,
    name character varying(50),
    description text,
    status character varying(30) NOT NULL,
    CONSTRAINT fk_team FOREIGN KEY (fk_team) REFERENCES team (id)
);

CREATE TABLE IF NOT EXISTS employee_in_team
(
    fk_team bigint NOT NULL,
    fk_employee bigint NOT NULL,
    role character varying(30) NOT NULL,
    CONSTRAINT fk_team FOREIGN KEY (fk_team) REFERENCES team (id),
    CONSTRAINT fk_employee FOREIGN KEY (fk_employee) REFERENCES employee (id)
);

CREATE TABLE IF NOT EXISTS task
(
    id serial PRIMARY KEY,
    name character varying(50) NOT NULL,
    description text,
    fk_employee int,
    fk_project int,
    labour_hours numeric(21,0),
    deadline timestamp(6) NOT NULL,
    status character varying(30) NOT NULL,
    author_id int NOT NULL,
    author character varying(50),
    creation_date timestamp(6) NOT NULL,
    update_date timestamp(6) NOT NULL,
    CONSTRAINT fk_project FOREIGN KEY (fk_project) REFERENCES project (id),
    CONSTRAINT fk_employee FOREIGN KEY (fk_employee) REFERENCES employee (id)
);

INSERT INTO team (name)
VALUES ('VTEC'),
       ('GOTY'),
       ('ОАО ЖирАвтоТранс');

INSERT INTO project (fk_team, code, name, description, status)
VALUES (1, 'XX-99-AA', 'Variable valve Timing and lift Electronic Control', '---', 'DEVELOPING'),
       (2, 'ZZ-56-ER', 'Game Of The Year', 'Lets just attach the cart to the shield', 'DRAFT'),
       (3, 'CC-73-HT','Автотранспортная ИС', 'ИС для автотранспорта', 'TESTING');

INSERT INTO employee (firstname, lastname, fathername, position, account, email, status, password, is_temporary_pwd)
VALUES
    ('Иван', 'Иванов', 'Петрович', 'менеджер', 'ivan747', 'ivan@company.com', 'ACTIVE', 'qwerty123', FALSE),
    ('Петр', 'Петров', 'Иванович','разработчик', 'petr1989', 'petr@company.com', 'ACTIVE', 'securepass', FALSE),
    ('Анна', 'Сидорова','Григорьевна', 'дизайнер', 'anna-s', 'anna@company.com', 'ACTIVE', 'qwerty', FALSE),
    ('Дмитрий', 'Смирнов', 'Анатольевич', 'аналитик', 'dmitriy123', 'dmitriy@company.com', 'ACTIVE', 'myPassword', FALSE),
    ('Анастасия', 'Королева', 'Павловна', 'менеджер', 'anastasia', 'anastasia@company.com', 'ACTIVE', '1234Password', FALSE),
    ('Артем', 'Кузнецов', 'Александрович', 'тестировщик', 'artem-test', 'artem@company.com', 'ACTIVE', 'bestPassword', FALSE),
    ('Евгений', 'Миронов', 'Сергеевич', 'менеджер', 'evgeniy1987', 'evgeniy@company.com', 'ACTIVE', 'coolPassword', FALSE),
    ('Наталья', 'Сергеева', 'Игоревна', 'разработчик', 'natalya81', 'natalya@company.com', 'ACTIVE', 'newPassword', FALSE),
    ('Сергей', 'Ковалев', 'Григорьевич', 'аналитик', 'sergey-k', 'sergey@company.com', 'ACTIVE', 'strongPassword', FALSE),
    ('Мария', 'Козлова', 'Александровна', 'дизайнер', 'mariya1985', 'mariya@company.com', 'ACTIVE', 'amazingPassword', FALSE),
    ('Ирина', 'Николаева', 'Петровна', 'менеджер', 'irina2010', 'irina@company.com', 'ACTIVE', 'pass12345', FALSE),
    ('Василий', 'Зайцев', 'Владимирович', 'разработчик', 'vasiliy1988', 'vasiliy@company.com', 'ACTIVE', 'password123', FALSE);

INSERT INTO employee_in_team
VALUES
    (1, 1, 'PROJECT_MANAGER'),
    (1, 2, 'ANALYST'),
    (1, 3, 'TESTER'),
    (1, 4, 'PROGRAMMER'),
    (2, 5, 'PROJECT_MANAGER'),
    (2, 6, 'ANALYST'),
    (2, 7, 'TESTER'),
    (2, 8, 'PROGRAMMER'),
    (3, 9, 'PROJECT_MANAGER'),
    (3, 10, 'ANALYST'),
    (3, 11, 'TESTER'),
    (3, 12, 'PROGRAMMER');

-- INSERT INTO task (name, description, fk_employee, fk_project, labour_hours, deadline, status, author_id, author, creation_date, update_date)
-- VALUES
--     ('Написать документацию', 'Написать документацию к проекту', 2, 1, '01:30:00', '2022-10-01', 'COMPLETED', 5, 'Иванов', '2022-07-16', '2022-07-20'),
--     ('Разработка новой фичи', 'Добавить возможность редактирования профиля', 3, 1, '08:00:00', '2022-12-31', 'NEW', 6, 'Петров', '2022-07-19', '2022-07-23'),
--     ('Тестирование функционала', 'Проверить работоспособность сайта', 4, 1, '16:00:00', '2022-09-15', 'IN_PROGRESS', 2, 'Королева', '2022-07-23', '2022-07-30'),
--     ('Оптимизация скорости работы', 'Ускорение загрузки страниц', 5, 2, '24:00:00', '2022-11-30', 'NEW', 3, 'Сидорова', '2022-07-24', '2022-08-02'),
--     ('Разработка личного кабинета', 'Создание личного кабинета для пользователей', 6, 2, '16:00:00', '2022-10-15', 'COMPLETED', 1, 'Иванова', '2022-07-31', '2022-08-02'),
--     ('Рефакторинг кода', 'Улучшение архитектуры проекта', 7, 2, '40:00:00', '2022-12-31', 'NEW', 9, 'Ковалев', '2022-08-01', '2022-08-06'),
--     ('Анализ конкурентов', 'Провести исследование конкурентов', 8, 2, '02:30:00', '2022-09-30', 'IN_PROGRESS', 12, 'Николаева', '2022-08-02', '2022-08-05'),
--     ('Обновление дизайна', 'Смена дизайна сайта', 1, 1, '32:00:00', '2022-11-01', 'NEW', 10, 'Зайцев', '2022-08-04', '2022-08-09'),
--     ('Добавление новых функций', 'Добавить возможность отправки сообщений в чате', 2, 1, '10:00:00', '2022-12-15', 'IN_PROGRESS', 1, 'Иванова', '2022-08-05', '2022-08-09'),
--     ('Тестирование безопасности', 'Проверка на отсутствие уязвимостей', 3, 1, '16:00:00', '2022-09-20', 'COMPLETED', 2, 'Королева', '2022-08-06', '2022-08-08'),
--     ('Создание новых страниц', 'Создание страницы о нас', 4, 1, '08:00:00', '2022-10-01', 'NEW', 5, 'Иванов', '2022-08-08', '2022-08-13'),
--     ('Разработка мобильного приложения', 'Разработка приложения для iOS и Android', 5, 2, '80:00:00', '2023-04-01', 'NEW', 3, 'Сидорова', '2022-08-09', '2022-08-14'),
--     ('Тестирование новой функциональности', 'Проверка новой функции на работоспособность', 6, 2, '20:00:00', '2022-09-30', 'IN_PROGRESS', 8, 'Миронов', '2022-08-10', '2022-08-13'),
--     ('Написание автоматических тестов', 'Разработка скриптов для автоматического тестирования', 7, 2, '48:00:00', '2022-12-31', 'NEW', 9, 'Ковалев', '2022-08-12', '2022-08-16'),
--     ('Оптимизация базы данных', 'Ускорение работы приложения за счет оптимизации БД', 8, 2, '24:00:00', '2022-11-15', 'COMPLETED', 1, 'Иванова', '2022-08-15', '2022-08-18'),
--     ('Построение аналитики', 'Создание отчетов по количеству пользователей', 1, 1, '16:00:00', '2022-10-31', 'IN_PROGRESS', 11, 'Козлова', '2022-08-16', '2022-08-20'),
--     ('Внедрение системы оплаты', 'Добавление возможности оплаты в приложении', 2, 1, '12:00:00', '2022-11-30', 'IN_PROGRESS', 5, 'Иванов', '2022-08-18', '2022-08-22'),
--     ('Разработка интерфейса', 'Создание нового интерфейса для сайта', 3, 1, '24:00:00', '2022-12-15', 'NEW', 6, 'Петров', '2022-08-20', '2022-08-25'),
--     ('Тестирование масштабируемости', 'Проверка работоспособности при большом количестве пользователей', 4, 1, '40:00:00', '2023-01-15', 'IN_PROGRESS', 7, 'Кузнецов', '2022-08-22', '2022-08-27'),
--     ('Анализ пользовательского опыта', 'Провести исследование пользовательского опыта', 5, 2, '03:00:00', '2022-10-20', 'COMPLETED', 12, 'Николаева', '2022-08-23', '2022-08-26'),
--     ('Разработка новых фишек', 'Добавить новые фичи в приложение', 6, 2, '24:00:00', '2022-11-30', 'IN_PROGRESS', 8, 'Миронов', '2022-08-24', '2022-08-28'),
--     ('Оптимизация SEO', 'Улучшение рейтинга сайта в выдаче поисковых систем', 7, 2, '16:00:00', '2022-10-15', 'COMPLETED', 3, 'Сидорова', '2022-08-27', '2022-08-30'),
--     ('Разработка механизма обновления', 'Создание механизма автоматического обновления приложения', 8, 2, '40:00:00', '2022-12-31', 'NEW', 9, 'Ковалев', '2022-08-26', '2022-09-01'),
--     ('Тестирование на разных браузерах', 'Проверка работы приложения в разных браузерах', 9, 3, '06:00:00', '2022-10-10', 'IN_PROGRESS', 11, 'Козлова', '2022-08-28', '2022-09-01'),
--     ('Внедрение системы уведомлений', 'Добавление уведомлений пользователей в приложении', 2, 1, '08:00:00', '2022-12-15', 'IN_PROGRESS', 5, 'Иванов', '2022-08-30', '2022-09-02'),
--     ('Разработка аналога конкурентов', 'Создание нового продукта с аналогичными функциями', 12, 3, '160:00:00', '2023-06-01', 'NEW', 6, 'Петров', '2022-09-01', '2022-09-06'),
--     ('Тестирование на безопасность', 'Проверка на наличие уязвимостей в приложении', 4, 1, '24:00:00', '2022-10-31', 'IN_PROGRESS', 7, 'Кузнецов', '2022-09-02', '2022-09-07'),
--     ('Анализ потребностей пользователей', 'Исследование требований и желаний пользователей', 5, 2, '10:00:00', '2022-10-20', 'COMPLETED', 12, 'Николаева', '2022-09-03', '2022-09-06'),
--     ('Добавление интерактивных элементов', 'Добавление интерактивных элементов на страницу', 6, 2, '04:00:00', '2022-10-15', 'IN_PROGRESS', 8, 'Миронов', '2022-09-04', '2022-09-07'),
--     ('Оптимизация скорости загрузки', 'Улучшение времени загрузки страницы', 7, 2, '16:00:00', '2022-11-01', 'IN_PROGRESS', 3, 'Сидорова', '2022-09-06', '2022-09-09'),
--     ('Обновление документации', 'Обновление документации к проекту', 8, 2, '02:00:00', '2022-10-10', 'NEW', 9, 'Ковалев', '2022-09-08', '2022-09-12'),
--     ('Тестирование отказоустойчивости', 'Проверка работы приложения при отказах системы', 1, 1, '12:00:00', '2022-11-30', 'IN_PROGRESS', 11, 'Козлова', '2022-09-09', '2022-09-13'),
--     ('Внедрение системы аналитики', 'Добавление системы аналитической отчетности', 10, 3, '20:00:00', '2022-12-31', 'IN_PROGRESS', 5, 'Иванов', '2022-09-11', '2022-09-16'),
--     ('Разработка интерфейса пользователя', 'Создание новой версии пользовательского интерфейса', 3, 1, '32:00:00', '2022-10-31', 'NEW', 6, 'Петров', '2022-09-12', '2022-09-17'),
--     ('Тестирование масштабируемости приложения', 'Проверка работоспособности приложения при большом количестве пользователей', 4, 1, '40:00:00', '2023-02-01', 'IN_PROGRESS', 7, 'Кузнецов', '2022-09-13', '2022-09-18'),
--     ('Анализ рынка', 'Провести исследование рынка и конкурентов', 5, 2, '08:00:00', '2022-11-15', 'COMPLETED', 12, 'Николаева', '2022-09-14', '2022-09-17'),
--     ('Разработка новой функциональности', 'Разработка новой функциональности для приложения', 6, 2, '80:00:00', '2023-05-01', 'IN_PROGRESS', 8, 'Миронов', '2022-09-15', '2022-09-20'),
--     ('Оптимизация работы с базой данных', 'Улучшение скорости работы с базой данных', 7, 2, '24:00:00', '2022-11-30', 'IN_PROGRESS', 3, 'Сидорова', '2022-09-17', '2022-09-20'),
--     ('Разработка механизмов рекомендаций', 'Создание механизмов рекомендации клиентам', 8, 2, '40:00:00', '2023-01-15', 'NEW', 9, 'Ковалев', '2022-09-19', '2022-09-23'),
--     ('Тестирование взаимодействия с внешними сервисами', 'Проверка взаимодействия с внешними сервисами', 1, 1, '16:00:00', '2022-11-01', 'IN_PROGRESS', 11, 'Козлова', '2022-09-20', '2022-09-24'),
--     ('Внедрение системы управления задачами', 'Добавление системы управления задачами в приложении', 2, 1, '24:00:00', '2023-01-01', 'IN_PROGRESS', 5, 'Иванов', '2022-09-22', '2022-09-27'),
--     ('Разработка аналитических отчетов', 'Создание системы аналитической отчетности', 3, 1, '40:00:00', '2022-12-15', 'NEW', 6, 'Петров', '2022-09-23', '2022-09-28'),
--     ('Тестирование системы логирования', 'Проверка работы системы логирования ошибок', 4, 1, '08:00:00', '2022-12-31', 'IN_PROGRESS', 7, 'Кузнецов', '2022-09-24', '2022-09-28'),
--     ('Анализ пользовательской активности', 'Исследование пользовательской активности для оптимизации приложения', 5, 2, '12:00:00', '2022-12-01', 'COMPLETED', 12, 'Николаева', '2022-09-25', '2022-09-28'),
--     ('Разработка системы обработки информации', 'Создание системы обработки большого объема информации', 9, 3, '120:00:00', '2023-07-01', 'IN_PROGRESS', 8, 'Миронов', '2022-09-26', '2022-09-30'),
--     ('Оптимизация алгоритмов поиска', 'Улучшение алгоритмов поиска на сайте', 11, 3, '24:00:00', '2022-12-01', 'IN_PROGRESS', 3, 'Сидорова', '2022-09-28', '2022-10-01'),
--     ('Обновление информации для клиентов', 'Добавление новой информации для клиентов на сайте', 12, 3, '12:00:00', '2022-11-01', 'NEW', 9, 'Ковалев', '2022-09-30', '2022-10-04'),
--     ('Тестирование механизма банковских переводов', 'Проверка механизма банковского перевода денег', 10, 3, '08:00:00', '2022-12-15', 'IN_PROGRESS', 11, 'Козлова', '2022-10-01', '2022-10-04'),
--     ('Внедрение уведомлений с помощью SMS', 'Добавление системы уведомлений с помощью SMS', 11, 3, '12:00:00', '2022-12-31', 'IN_PROGRESS', 5, 'Иванов', '2022-10-03', '2022-10-07');


INSERT INTO task (name, description, fk_employee, fk_project, labour_hours, deadline, status, author_id, author, creation_date, update_date)
VALUES
    ('Написать документацию', 'Написать документацию к проекту', 2, 1, '90', '2022-10-01', 'COMPLETED', 5, 'Иванов', '2022-07-16', '2022-07-20'),
    ('Разработка новой фичи', 'Добавить возможность редактирования профиля', 3, 1, '480', '2022-12-31', 'NEW', 6, 'Петров', '2022-07-19', '2022-07-23'),
    ('Тестирование функционала', 'Проверить работоспособность сайта', 4, 1, '960', '2022-09-15', 'IN_PROGRESS', 2, 'Королева', '2022-07-23', '2022-07-30'),
    ('Оптимизация скорости работы', 'Ускорение загрузки страниц', 5, 2, '1440', '2022-11-30', 'NEW', 3, 'Сидорова', '2022-07-24', '2022-08-02'),
    ('Разработка личного кабинета', 'Создание личного кабинета для пользователей', 6, 2, '960', '2022-10-15', 'COMPLETED', 1, 'Иванова', '2022-07-31', '2022-08-02'),
    ('Рефакторинг кода', 'Улучшение архитектуры проекта', 7, 2, '2400', '2022-12-31', 'NEW', 9, 'Ковалев', '2022-08-01', '2022-08-06'),
    ('Анализ конкурентов', 'Провести исследование конкурентов', 8, 2, '150', '2022-09-30', 'IN_PROGRESS', 12, 'Николаева', '2022-08-02', '2022-08-05'),
    ('Обновление дизайна', 'Смена дизайна сайта', 1, 1, '1920', '2022-11-01', 'NEW', 10, 'Зайцев', '2022-08-04', '2022-08-09'),
    ('Добавление новых функций', 'Добавить возможность отправки сообщений в чате', 2, 1, '600', '2022-12-15', 'IN_PROGRESS', 1, 'Иванова', '2022-08-05', '2022-08-09'),
    ('Тестирование безопасности', 'Проверка на отсутствие уязвимостей', 3, 1, '960', '2022-09-20', 'COMPLETED', 2, 'Королева', '2022-08-06', '2022-08-08'),
    ('Создание новых страниц', 'Создание страницы о нас', 4, 1, '480', '2022-10-01', 'NEW', 5, 'Иванов', '2022-08-08', '2022-08-13'),
    ('Разработка мобильного приложения', 'Разработка приложения для iOS и Android', 5, 2, '4800', '2023-04-01', 'NEW', 3, 'Сидорова', '2022-08-09', '2022-08-14'),
    ('Тестирование новой функциональности', 'Проверка новой функции на работоспособность', 6, 2, '1200', '2022-09-30', 'IN_PROGRESS', 8, 'Миронов', '2022-08-10', '2022-08-13'),
    ('Написание автоматических тестов', 'Разработка скриптов для автоматического тестирования', 7, 2, '2880', '2022-12-31', 'NEW', 9, 'Ковалев', '2022-08-12', '2022-08-16'),
    ('Оптимизация базы данных', 'Ускорение работы приложения за счет оптимизации БД', 8, 2, '1440', '2022-11-15', 'COMPLETED', 1, 'Иванова', '2022-08-15', '2022-08-18'),
    ('Построение аналитики', 'Создание отчетов по количеству пользователей', 1, 1, '960', '2022-10-31', 'IN_PROGRESS', 11, 'Козлова', '2022-08-16', '2022-08-20'),
    ('Внедрение системы оплаты', 'Добавление возможности оплаты в приложении', 2, 1, '720', '2022-11-30', 'IN_PROGRESS', 5, 'Иванов', '2022-08-18', '2022-08-22'),
    ('Разработка интерфейса', 'Создание нового интерфейса для сайта', 3, 1, '1440', '2022-12-15', 'NEW', 6, 'Петров', '2022-08-20', '2022-08-25'),
    ('Тестирование масштабируемости', 'Проверка работоспособности при большом количестве пользователей', 4, 1, '2400', '2023-01-15', 'IN_PROGRESS', 7, 'Кузнецов', '2022-08-22', '2022-08-27'),
    ('Анализ пользовательского опыта', 'Провести исследование пользовательского опыта', 5, 2, '180', '2022-10-20', 'COMPLETED', 12, 'Николаева', '2022-08-23', '2022-08-26'),
    ('Разработка новых фишек', 'Добавить новые фичи в приложение', 6, 2, '1440', '2022-11-30', 'IN_PROGRESS', 8, 'Миронов', '2022-08-24', '2022-08-28'),
    ('Оптимизация SEO', 'Улучшение рейтинга сайта в выдаче поисковых систем', 7, 2, '960', '2022-10-15', 'COMPLETED', 3, 'Сидорова', '2022-08-27', '2022-08-30'),
    ('Разработка механизма обновления', 'Создание механизма автоматического обновления приложения', 8, 2, '2400', '2022-12-31', 'NEW', 9, 'Ковалев', '2022-08-26', '2022-09-01'),
    ('Тестирование на разных браузерах', 'Проверка работы приложения в разных браузерах', 9, 3, '360', '2022-10-10', 'IN_PROGRESS', 11, 'Козлова', '2022-08-28', '2022-09-01'),
    ('Внедрение системы уведомлений', 'Добавление уведомлений пользователей в приложении', 2, 1, '480', '2022-12-15', 'IN_PROGRESS', 5, 'Иванов', '2022-08-30', '2022-09-02'),
    ('Разработка аналога конкурентов', 'Создание нового продукта с аналогичными функциями', 12, 3, '9600', '2023-06-01', 'NEW', 6, 'Петров', '2022-09-01', '2022-09-06'),
    ('Тестирование на безопасность', 'Проверка на наличие уязвимостей в приложении', 4, 1, '1440', '2022-10-31', 'IN_PROGRESS', 7, 'Кузнецов', '2022-09-02', '2022-09-07'),
    ('Анализ потребностей пользователей', 'Исследование требований и желаний пользователей', 5, 2, '600', '2022-10-20', 'COMPLETED', 12, 'Николаева', '2022-09-03', '2022-09-06'),
    ('Добавление интерактивных элементов', 'Добавление интерактивных элементов на страницу', 6, 2, '240', '2022-10-15', 'IN_PROGRESS', 8, 'Миронов', '2022-09-04', '2022-09-07'),
    ('Оптимизация скорости загрузки', 'Улучшение времени загрузки страницы', 7, 2, '960', '2022-11-01', 'IN_PROGRESS', 3, 'Сидорова', '2022-09-06', '2022-09-09'),
    ('Обновление документации', 'Обновление документации к проекту', 8, 2, '120', '2022-10-10', 'NEW', 9, 'Ковалев', '2022-09-08', '2022-09-12'),
    ('Тестирование отказоустойчивости', 'Проверка работы приложения при отказах системы', 1, 1, '720', '2022-11-30', 'IN_PROGRESS', 11, 'Козлова', '2022-09-09', '2022-09-13'),
    ('Внедрение системы аналитики', 'Добавление системы аналитической отчетности', 10, 3, '1200', '2022-12-31', 'IN_PROGRESS', 5, 'Иванов', '2022-09-11', '2022-09-16'),
    ('Разработка интерфейса пользователя', 'Создание новой версии пользовательского интерфейса', 3, 1, '1920', '2022-10-31', 'NEW', 6, 'Петров', '2022-09-12', '2022-09-17'),
    ('Тестирование масштабируемости приложения', 'Проверка работоспособности приложения при большом количестве пользователей', 4, 1, '2400', '2023-02-01', 'IN_PROGRESS', 7, 'Кузнецов', '2022-09-13', '2022-09-18'),
    ('Анализ рынка', 'Провести исследование рынка и конкурентов', 5, 2, '480', '2022-11-15', 'COMPLETED', 12, 'Николаева', '2022-09-14', '2022-09-17'),
    ('Разработка новой функциональности', 'Разработка новой функциональности для приложения', 6, 2, '4800', '2023-05-01', 'IN_PROGRESS', 8, 'Миронов', '2022-09-15', '2022-09-20'),
    ('Оптимизация работы с базой данных', 'Улучшение скорости работы с базой данных', 7, 2, '1440', '2022-11-30', 'IN_PROGRESS', 3, 'Сидорова', '2022-09-17', '2022-09-20'),
    ('Разработка механизмов рекомендаций', 'Создание механизмов рекомендации клиентам', 8, 2, '2400', '2023-01-15', 'NEW', 9, 'Ковалев', '2022-09-19', '2022-09-23'),
    ('Тестирование взаимодействия с внешними сервисами', 'Проверка взаимодействия с внешними сервисами', 1, 1, '960', '2022-11-01', 'IN_PROGRESS', 11, 'Козлова', '2022-09-20', '2022-09-24'),
    ('Внедрение системы управления задачами', 'Добавление системы управления задачами в приложении', 2, 1, '1440', '2023-01-01', 'IN_PROGRESS', 5, 'Иванов', '2022-09-22', '2022-09-27'),
    ('Разработка аналитических отчетов', 'Создание системы аналитической отчетности', 3, 1, '2400', '2022-12-15', 'NEW', 6, 'Петров', '2022-09-23', '2022-09-28'),
    ('Тестирование системы логирования', 'Проверка работы системы логирования ошибок', 4, 1, '480', '2022-12-31', 'IN_PROGRESS', 7, 'Кузнецов', '2022-09-24', '2022-09-28'),
    ('Анализ пользовательской активности', 'Исследование пользовательской активности для оптимизации приложения', 5, 2, '720', '2022-12-01', 'COMPLETED', 12, 'Николаева', '2022-09-25', '2022-09-28'),
    ('Разработка системы обработки информации', 'Создание системы обработки большого объема информации', 9, 3, '7200', '2023-07-01', 'IN_PROGRESS', 8, 'Миронов', '2022-09-26', '2022-09-30'),
    ('Оптимизация алгоритмов поиска', 'Улучшение алгоритмов поиска на сайте', 11, 3, '1440', '2022-12-01', 'IN_PROGRESS', 3, 'Сидорова', '2022-09-28', '2022-10-01'),
    ('Обновление информации для клиентов', 'Добавление новой информации для клиентов на сайте', 12, 3, '720', '2022-11-01', 'NEW', 9, 'Ковалев', '2022-09-30', '2022-10-04'),
    ('Тестирование механизма банковских переводов', 'Проверка механизма банковского перевода денег', 10, 3, '480', '2022-12-15', 'IN_PROGRESS', 11, 'Козлова', '2022-10-01', '2022-10-04'),
    ('Внедрение уведомлений с помощью SMS', 'Добавление системы уведомлений с помощью SMS', 11, 3, '720', '2022-12-31', 'IN_PROGRESS', 5, 'Иванов', '2022-10-03', '2022-10-07');
