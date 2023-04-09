## Запуск автотестов (postgresql):
1. Запустить Docker Desktop;
2. Открыть проект в IntelliJ IDEA;
3. В терминале в корне проекта запустить контейнеры:
   docker-compose up;
4. Запустить приложение:
   java -jar .\artifacts\aqa-shop.jar;
5. Открыть второй терминал;
6. Запустить тесты:
   .\gradlew clean test -DdbUrl=jdbc:postgresql://localhost:5432/app;
7. Открыть в браузере отчет: file:///C:/Autotests/Dimlom/build/reports/tests/test/index.html;
8. Закрыть отчёт; 
9. Остановить контейнеры:
    docker-compose down. 
10. Оставить приложение aqa-shop.jar (красный квадрат).


## Запуск автотестов (mysql):
1. Запустить Docker Desktop;
2. Открыть проект в IntelliJ IDEA;
3. В терминале в корне проекта запустить контейнеры:
   docker-compose up;
4. Запустить приложение aqa-shop.jar (зеленый треугольник);
5. Открыть второй терминал;
6. Запустить тесты:
   .\gradlew clean test -DdbUrl=jdbc:mysql://localhost:3306/app;
7. Открыть в браузере отчет: file:///C:/Autotests/Dimlom/build/reports/tests/test/index.html;
8. Закрыть отчёт; 
9. Остановить контейнеры:
    docker-compose down; 
10. Оставить приложение aqa-shop.jar (красный квадрат).