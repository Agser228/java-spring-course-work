Java Spring Course Work 4th Semester MIREA

Сервис позволяет организовывать работу детского лагеря:
- создавать отряды
- распределять вожатых
- быстро получать доступ к информации о детях


Возможно несколько ролей при работе с сервисом:
Администратор
Родитель
Работник

Каждая из ролей обладает различным количеством функций:
Администратор:
- может добавлять новых работников
- может удалять работников
- может открывать смены
- менять состав отрядов

Родитель:
- может создать путевку
- может просматривать отряды

Работник:
- может просматривать отряды


Структура страниц
- Список отрядов (Отряды)
  Отряд 1 (посмотреть/изменить)
    - Список детей (добавить)
      Ребенок 1 (посмотреть/изменить/удалить)
      Ребенок 2
  Отряд 2

- Список работников (Кадры) (добавить)
  Работник 1 (посмотреть/изменить/удалить)
  Работник 2

- Заполнение путевок
- Изменение в базе

##################################################################
Функциональные сценарии
##################################################################

Администратор
-> Открыть смену - указать размер смены

Родитель
-> Регистрируется
-> Отправляет заявку
	- вводит данные себя и ребенка
-> Запрашивает состояние заявки

У заявки три состояния:
- на рассмотрении
- принята 
	- {Ваш ребенок в отряде №10}
	- {Ожидается распределение на отряды}
- отклонена

Администратор
-> Принимает заявки / Отклоняет заявки - пишет причину отклонения

Администратор
-> Сформировать отряды
	- указать количество отрядов
	- указать смену, к которой они относятся

[Отряды сформированы, дети распределены по сменам]

-> Установить к отрядам вожатых

Администратор
-> Устроить работника
-> Удалить работника
-> Удалить вожатого
	- Вожатый прикреплен к отряду? 
	- Открепить вожатого от отряда


##############################################################
Пользователи и страницы им доступные
##############################################################

Родитель
- Страница входа / регистрации
- Отправить путевку / Проверить состояние путевки
- Страница отрядов

Вожатый
- Страница входа
- Страница отрядов

Администратор
- Страница входа
- Страница заявок / путевок
- Страница работников
- Страница отрядов
- Страница смен

Родителю:
api/v1/squad
api/v1/voucher


Вожатому:
api/v1/
	squad

Администратору:
api/v1/
	squad
	voucher
	worker
	shift
	schema
	parent
	child


На React:

Производить регистрацию/вход пользователя -
получать роли и в зависимости от типа роли предлагать различные страницы 


















