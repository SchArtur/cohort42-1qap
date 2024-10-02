# language: ru

@all @LoginPage
Функция: Login Page

  Предыстория:
    Если есть кнопка 'Sign_Out' то нажимаем на нёё
    * нажимаем на кнопку 'LOGIN' в заголовке

  Сценарий: Проверка успешной авторизации с параметром TEST_USER
    * заполняем данные пользователя TEST_USER
    * нажимаем на кнопку 'login'
    * проверяем наличие кнопки 'SignOut'

  Сценарий: Проверка успешной авторизации
    * заполняем данные пользователя
      | Name     | testg@mail.com |
      | Password | Manuel1234$    |
    * нажимаем на кнопку 'login'
    * проверяем наличие кнопки 'SignOut'

  Сценарий: Проверка авторизации c не валидными данными
    * заполняем данные пользователя
      | Name     | testg@mail.com |
      | Password | Manue4$        |
    * нажимаем на кнопку 'login'
    * проверяем текст всплывающего уведомления - "Wrong email or password"
    * проверяем текст ошибки - "Login Failed with code 401"

  Сценарий: Проверка успешной регистрации
    * заполняем данные пользователя NEW_USER
    * нажимаем на кнопку Registration на форме ввода
    * проверяем наличие кнопки 'SignOut'

  Структура сценария: Проверка регистрации с не валидными данными
    * заполняем данные пользователя
      | Name     | <Name>     |
      | Password | <Password> |
    * нажимаем на кнопку Registration на форме ввода
    * проверяем текст всплывающего уведомления - "Wrong email or password format"
    * проверяем наличие кнопки 'SignOut'
    Примеры:
      | Name          | Password    |
      | manuelgm.com  | Manuel1234$ |
      | manuel@.com  | Manuel1234$ |
      | manuel@go.com | masdfa1$    |
      | manuel@go.com | MASdfa1     |
      | manuel@go.com | MASdfa$     |
    