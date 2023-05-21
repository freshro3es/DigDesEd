# DigDesEd

## Архитектура системы
Изображение архитектуры системы:
![image](https://github.com/freshro3es/DigDesEd/assets/104096803/03a4113e-c131-44f1-9593-5fc81515d036)

### Описание модулей

#### View
Модуль отвечает за взаимодействие с пользователем. То есть код модуля View определяет внешний вид приложения и способы его использования.

#### Controller
Модуль принимает по определенному протоколу запросы и отдает ответ клиенту (HTTP + JSON).

#### DTO
Модуль содержит модель представления. Те сущности, с которыми работает View.

#### Service
Модуль, в котором находится слой бизнес-логики, который выполняет какие-либо логические операции над данными.

#### Model
Модуль модели бизнес-данных, с которыми работает бизнес-слой. Здесь хранятся не только сущности данных из БД, но и вспомогательные сущности.

#### Mapping
Вспомогательный модуль для преобразования модели в DTO и обратно.

#### DAO
Модуль для работы с базой данных, который содержит методы для запросов в базу данных.

## Разделение итоговой задачи построения ИС на блоки

### Построение модели данных (Model)

### Работа с БД (DAO)

#### ER диаграмма данных

![image](https://github.com/freshro3es/DigDesEd/assets/104096803/042e7779-ed2b-44e0-b08c-8e93b6055087)

#### Детализация ER диаграммы

![image](https://github.com/freshro3es/DigDesEd/assets/104096803/0eeacef0-666d-48a5-8c89-010f339cdc78)


### Построение модели данных представления (DTO)

### Работа над модулем преобразования моделей (Mapping)

### Разработка бизнес-логики приложения (Service)

### Построение пользовательского представления (приложения)

### Образование связи между клиентом и сервером (Controller)
