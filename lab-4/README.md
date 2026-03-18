# Лабораторная работа 4
# Java Message Service
## Бурлаков Алексей группа 6131-010402D
## Казаков Николай группа 6131-010402D

---

You are to add some new functionality to the previous application, namely a logging mechanism and a “watchdog” for a specific kind of changes.

Logging should provide a simple mechanism to put information on changes in your system into a special table of the database.

“Watchdog” should send e-mail notifications on specific changes in the system to some specified e-mail addresses.

It is strongly recommended to use version control and source code management system (like GitHub).

It is strongly recommended to use Maven to manage your project.
You can choose any IDE, but IntelliJ IDEA is recommended.

---

В качестве JMS был выбран ActiveMQ, запускался через Docker (docker-compose.yaml).

LoggingAspectDatabaseChanges.java - сервис отслеживающий изменения в базе данных:

![](/pictures/lab-4-pics/logging.png)

Созданы сервисные классы для отправки и прослушивания ивентов: JmcEventSender и JmcListenerService.


JmcEventSender.java

![](/pictures/lab-4-pics/eventsender.png)

JmcListenerService.java

![](/pictures/lab-4-pics/listener.png)

Пример работы: 

Таблица emails:

![](/pictures/lab-4-pics/email.png)

Таблица events:

![](/pictures/lab-4-pics/event.png)