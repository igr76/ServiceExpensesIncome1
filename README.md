<h1>Сервис для распределения и расчета эффективности расходов</h1>

## Описание
Версия программы: 0.0.1



## Реализованный функционал

- Регистрация и вход.
- Ведение справочника зданий.
- Ведение справочника основных средств;.
- Ведение справочника работ/услуг;.
- Ведение справочника договоров..
- Можно изменять(удалять) свои данные и задачи
- Хранение и получение истории результатов распределения расходов
- Прогнозирование и контроль затрат

## Запуск

Вариант 1

- Скачиваем весь проект
- Запускаем Docker
- В корне проекта есть файл docker-compose.yaml  
  Пароли, логины и хосты можно поменять в самом файле.
- Запускаем его командой docker compose up
- Документация Api реализована с помощью свагера по адресу http://localhost:8081/swagger-ui/index.html.
  После запуска будет доступна по порту 8081.

Вариант 2

Клонируем проект в IntelliJ IDEA.
Он находится по адресу https://github.com/igr76/taskManagement
Подключаем postgresql с заменой имени пользователя, Бд и пароля в [application.properties]
Запускаем проект.
Документация Api реализована с помощью свагера по адресу http://localhost:8081/swagger-ui/index.html.
После запуска будет доступна по порту 8081.

## Используемые технологии

- Java 17
- Spring Boot 3.1.1
- Liombok
- postgresql
- liquibase
- Mockito
- mapstruct
- spring security



## Автор проекта

- <a  href="https://github.com/igr76">Грицук Игорь</a>


