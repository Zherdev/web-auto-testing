WebAutoTesting
==============

Содержит два теста для страницы [Вакансии](https://www.tinkoff.ru/career/vacancies/).
Первый тест: прокликивание полей формы, проверка сообщений о незаполненных полях.
Второй тест: ввод невалидных значений, проверка сообщений о неправильном заполнении полей.


Запуск
------

Для запуска в браузере Chrome или Firefox полните команду

```
mvn -Dtest=FirstTest,SecondTest -Dbrowser=chrome
```
и команду

```
mvn -Dtest=FirstTest,SecondTest -Dbrowser=firefox
```

соответственно.

Для запуска в Opera выполните команду

```
mvn -Dtest=FirstTest,SecondTest -Dbrowser=opera -Dopera-binary=<PATH TO OPERA BINARY>
```

где <PATH TO OPERA BINARY> - путь к исполняемому файлу Opera.

Например:

```
mvn -Dtest=SecondTest -Dbrowser=opera -Dopera-binary=/usr/bin/opera
```
запустит второй тест в браузере Opera.


Автор
-----

Жердев Иван

http://www.zherdev.tech
