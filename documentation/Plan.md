# План автоматизации тестирования

## Позитивные и Негативные сценарии

I. **Позитивные сценарии:**
1. Успешная оплата тура "Путешествие дня", заполнив поля "Оплата по карте" по действующей карте (номер карты заполнен с пробелами после каждых 4 символов).
   _Ожидаемый результат:_ появление сообщения об успешной оплате тура;
2. Успешная оплата в кредит тура "Путешествие дня", заполнив поля "Кредит по данным карты" по действующей карте (номер карты заполнен с пробелами после каждых 4 символов).
   _Ожидаемый результат:_ появление сообщения об успешной взятие кредита;
3. Отказ в оплате тура "Путешествие дня", заполнив поля "Оплата по карте" по отклоненной карте (номер карты заполнен с пробелами после каждых 4 символов)
   _Ожидаемый результат:_ появление сообщения об отказе в оплате тура;
4. Отказ в кредите на покупку тура "Путешествие дня", заполнив поля "Кредит по данным карты" по отклоненной карте (номер карты заполнен с пробелами после каждых 4 символов)
   _Ожидаемый результат:_ появление сообщения об отказе в взятие кредита;
5. Оставление поля "Номер карты" пустым, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
   _Ожидаемый результат:_ под полем "Номер карты" появиться предупреждение об пустом поле;
6. Оставление поля "Месяц" пустым, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
   _Ожидаемый результат:_ под полем "Месяц" появиться предупреждение об пустом поле;
7. Заполнение поля "Месяц" значением 12, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
   _Ожидаемый результат:_ появление сообщения об успешной оплате тура;
8. Заполнение поля "Месяц" значением 09, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
   _Ожидаемый результат:_ появление сообщения об успешной оплате тура;
9. Заполнение поля "Год" и поля "Месяц" текущим периодом, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
   _Ожидаемый результат:_ появление сообщения об успешной оплате тура; 
10. Оставление поля "Год" пустым, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
   _Ожидаемый результат:_ под полем "Год" появиться предупреждение об пустом поле;
11. Заполнение поля "CVC/CVV" 3-мя цифрами, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
    _Ожидаемый результат:_ появление сообщения об успешной оплате тура;


II. **Негативные сценарии:**
1. Заполнение поля "Номер карты" 11 рандомными цифрами, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
   _Ожидаемый результат:_ под полем "Номер карты" появиться предупреждение о недопустимой длине поля;
2. Заполнение поля "Номер карты" 12 рандомными цифрами, остальные поля заполнены валидно* в форме "Оплата по карте" тура "Путешествие дня". _Ожидаемый результат:_ появление сообщения об отказе в оплате тура; 
3. Заполнение поля "Номер карты" 19 рандомными цифрами, остальные поля заполнены валидно* в форме "Оплата по карте" тура "Путешествие дня"
_Ожидаемый результат:_ появление сообщения об отказе в оплате тура; 
4. Заполнение поля "Номер карты" 20 рандомными цифрами, остальные поля заполнены валидно* в форме "Оплата по карте" тура "Путешествие дня"
_Ожидаемый результат:_ под полем "Номер карты" появиться предупреждение о недопустимой длине поля;
5. Заполнение поля "Месяц" значением 00, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
   _Ожидаемый результат:_ под полем "Месяц" появиться предупреждение (такого месяца нет);
6. Заполнение поля "Месяц" значением 13, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
   _Ожидаемый результат:_ под полем "Месяц" появиться предупреждение;
7. Заполнение поля "Месяц" значением 14, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
   _Ожидаемый результат:_ под полем "Месяц" появиться предупреждение;
8. Заполнение поля "Месяц" двумя рандомными символами, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
   _Ожидаемый результат:_ под полем "Месяц" появиться предупреждение;
9. Заполнение поля "Владелец", остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
   _Ожидаемый результат:_ появление сообщения об успешной оплате тура; 
10. Заполнение поля "Владелец" с дефисом, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
    _Ожидаемый результат:_ появление сообщения об успешной оплате тура;
11. Оставление поля "Владелец" пустым, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
    _Ожидаемый результат:_ под полем "Владелец" появиться предупреждение об пустом поле;
12. Заполнение поля "Владелец" рандомными спецсимволами, остальные поля заполнены  в форме "Оплата по карте" тура "Путешествие дня"
    _Ожидаемый результат:_ под полем "Владелец" появиться предупреждение;
13. Заполнение поля "CVC/CVV" 3 рандомными буквами, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
    _Ожидаемый результат:_ под полем "CVC/CVV" появление сообщения об невалидном значение
14. Заполнение поля "CVC/CVV" 3 рандомными симвалами, остальные поля заполнены в форме "Оплата по карте" тура "Путешествие дня"
    _Ожидаемый результат:_ под полем "CVC/CVV" появление сообщения об невалидном значение


## Перечень используемых инструментов
1. JUnit 5;
2. IntelliJ IDEA 2022.3.2 (Community Edition);
3. Selenide - популярный и простой инструмент для UI тестов;
4. Git и Github - веб-сервис для публикации и редактирование своего кода;
5. OpenJDK 11;
6. Windows 11 Домашняя для одного языка;
7. Lombok - Фреймворк для автогенерации кода с целью улучшить читаемость тестов.


## Перечень и описание возможных рисков при автоматизации
1. Сложность из-за требования совместимости с двумя БД: MySQL, PostgreSQL;
2. Симулятор платежной системы, написанный на другом языке. Нужно разобраться с тем как он работает, как взаимодействует с нашими БД;
3. Присутствие багов в приложении, нужно найти их и определить как они влияют на работоспособность приложения.


## Интервальная оценка с учётом рисков в часах
1. Подготовка окружения, развертывание БД - 7 часов (при отсутствии дополнительных рисков);
2. Написание автотестов, тестирование и отладка автотестов - 72 часа (при отсутствии дополнительных рисков);
3. Формирование и анализ отчетов - 8 часов.


## План сдачи работ
1. Авто-тесты будут готовы 15.04.2023
2. Баг-репорты и отчёт по результатам тестов: 15.04.2023
3. Отчёт по результатам автоматизации: 15.04.2023

