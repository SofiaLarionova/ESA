# Лабораторная работа 3
# RESTful web-service
## Бурлаков Алексей группа 6131-010402D
## Казаков Николай группа 6131-010402D

### General task

You are to develop an application with REST web-service interface. Application should provide access to data within a database.

It is strongly recommended to use version control and source code management system (like GitHub).

It is strongly recommended to use Maven to manage your project.

You can choose any IDE, but IntelliJ IDEA is recommended.

В данной работе был выбран Spring boot REST.



Причины использования Spring boot REST:

1. Интеграция с другими модулями Spring: Spring REST легко интегрируется с другими модулями Spring, такими как Spring Security, Spring Data, Spring Boot и т. д. Это обеспечивает более простую и гибкую разработку приложений.

2. Удобство конфигурации: Spring REST предлагает удобный и гибкий способ конфигурации через аннотации и XML-конфигурацию. Это позволяет легко настраивать поведение REST-сервисов и контроллеров.

3. Мощные функциональные возможности: Spring REST предоставляет мощные возможности для обработки запросов, валидации данных, обработки исключений и других задач, связанных с созданием RESTful API.

4. Поддержка сообществом: Spring Framework имеет большое сообщество разработчиков, что означает, что вы можете найти множество ресурсов, документации и поддержки для разработки приложений на Spring REST.

5. Простота использования: Spring REST предлагает простой и интуитивно понятный подход к созданию RESTful API, что делает процесс разработки более эффективным и приятным.

В данной задаче были разработаны REST-точки доступа для выполнения операций CRUD.

Коллекции Books

![](/pictures/lab-3-pics/bookcollections.png)

Также было реализовано XSLT преобразование, которое изменяет входные данные в формате XML.

![](/pictures/lab-3-pics/bookslist.png)

![](/pictures/lab-3-pics/bookdetails.png)

![](/pictures/lab-3-pics/modellist.png)

![](/pictures/lab-3-pics/modeldetails.png)

