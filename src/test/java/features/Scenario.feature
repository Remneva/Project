# language: ru

Функционал: аутентификация в автоматизированную систему учета активов

  Предыстория:

    * открывается страница с формой "Вход в систему"

  @11111
  Структура сценария: аутантификация с валидными данными

    * пользователь заполняет поле "Имя пользователя" значением "<логин>"
    * пользователь заполняет поле "Пароль" значением "<пароль>"
    * пользователь нажимает кнопку "Войти"
    * открывается модальное окно "Выбор финансовой организации"
    * пользователь выбирает финансовую организацию "10" типа КО
    * пользователь нажимает кнопку "Выбрать"
    * открывается страница с логотипом "Агентство по страхованию вкладов"
    * открывается страница с финансовой организацией "10"
    * пользователь нажимает кнопку "Права  Все"
    * пользователь нажимает кнопку "Выход" в контекстном меню


    Примеры:
      | логин   | пароль   |
      | sua_all | Q1w2e3r4 |
   #   | sua_al5451 | Q5551w2e3r4 |

  @11112
  Сценарий: аутентификация с невалидными данными
    *  пользователь заполняет поля "Имя пользователя" и "Пароль" значением
      | sua_alluys | 12341w2e |
    *  пользователь нажимает кнопку "Войти"
    *  открывается страница с сообщением "Неверное имя пользователя или пароль."