# Лабораторная работа 1
# Application with common JavaEE architecture
## Ларионова Софья группа 6231-010402D

### General task
You are to develop an application using common JavaEE architecture and technologies. It should have three layers (data, logic, view) and provide means to work with a database.

It is strongly recommended to use version control and source code management system (like GitHub).

It is strongly recommended to use Maven to manage your project.

You can choose any IDE, but IntelliJ IDEA is recommended.

You may not use IDE to deploy your project to an application server. All deployment should be made using administrative console.

### Задание 1
Download GlassFish application server.
Install it by unpacking the archive.
Start the application server.
Open an administrative console and go through its controls.
Мы использовали в реализации своего приложения Apache Tomcat 9.

![](/pictures/lab-1-pics/admin.png)

![](/pictures/lab-1-pics/serverstart.png)


### Задание 2
If you have no DBMS installed, please install one. You can choose any SQL DBMS you like, but PostgreSQL and MySQL are preferred.

В своей реализации мы использовали PostgreSQL и возможности IDEA в работе с SQL. PostgreSQL запускали через Docker. 



### Задание 3
Choose any subject area and make a model with at least two entities with a few properties.
Create a script to make a database for your model.

Мы решили создать таблицы книжного рейтинга и рейтинга моделей компьютерного зрения.
Создали сущности Book.java и CvModel.java
Мы создали скрипты для создания бд и добавили туда данные.

![](/pictures/lab-1-pics/entities.png)

### Задание 4
Develop data layer as Java Beans for the model and make them prepared for use with Entity Persistence.

Мы создали вспомогательные классы для работы с JDBC (пакет sql) и классы для выполнения CRUD-операций над моделью.

SQLHelper.java

![](/pictures/lab-1-pics/sqlhelper.png)

BookStorage.java

![](/pictures/lab-1-pics/bookstorage.png)


### Задание 5
Implement business layer for accessing data using session beans.

Мы добавили файлы сервлетов и сервисные файлы для представления бизнес логики.

BookServlet.java

![](/pictures/lab-1-pics/bookservlet.png)

### Задание 6
Implement view layer using any technology of your choice, which is applicable here.

Для слоя представления были созданы файлы .jsp.
И мы получили следующие выводы на веб страницу.

Страница main-page

![](/pictures/lab-1-pics/mainpage.png)

Главная страница содержит ссылки на страницы с CRUD операциями над Books и CVModels. Есть методы Add, Delete, Update:

Ниже показаны страницы Books и CV Models и реализовано добавление новых данных.


### Задание 7
Make everything work together…

Добавление новых данных в Models, добавлена прорывная модель LeXANet:

![](/pictures/lab-1-pics/cvmodels.png)

Добавление новых данных в Books, добавлен пробирающий до мурашек хоррор триллер "BIBKY":

![](/pictures/lab-1-pics/books.png)


Обновления данных:

![](/pictures/lab-1-pics/updatefeature.png)




