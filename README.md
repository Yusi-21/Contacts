# 📱 Contacts - Android приложение для управления контактами

Приложение для хранения и управления контактами с аутентификацией, базой данных SQLite и удобным интерфейсом.

## 🔍 Оглавление
1. [Введение](#-введение)
2. [Функционал](#-функционал)
3. [Технологии](#-технологии)
4. [Скриншоты](#-скриншоты)
5. [Установка](#-установка)

---

## 📌 Введение

### 1.1 Класс SharedPreferences
Используется для хранения легковесных данных (логин, настройки) в формате ключ-значение:
- Сохранение пользовательских предпочтений (тема, язык)
- Хранение состояния приложения между сессиями
- Кэширование небольших данных

```java
SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
prefs.edit().putString("username", "user123").apply();
```
### 1.2 База данных SQLite
Реализована через класс DatabaseHelper, который наследуется от SQLiteOpenHelper. Основные возможности:
- Создание и обновление БД
- CRUD-операции с контактами
- Поиск по имени и номеру телефона
Пример структуры таблицы контактов:

```sql
CREATE TABLE contacts (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    phone TEXT,
    email TEXT,
    address TEXT
)
```

## 🛠 Функционал
🛠 Функционал
- 🔒 Система аутентификации через SharedPreferences
- 📋 Просмотр списка всех контактов
- ➕ Добавление новых контактов
- ✏️ Редактирование существующих контактов
- 🗑 Удаление контактов
- 🔍 Поиск по имени и номеру телефона
- 📱 Адаптивный интерфейс для разных размеров экрана

Основные Activity:
- LoginActivity - экран входа
- ContactsActivity - список контактов
- ContactDetailActivity - просмотр деталей контакта
- CreateContactActivity - создание/редактирование контакта

## 💻 Технологии
💻 Технологии
- Язык программирования: Java
- Минимальная версия Android: 8.0 (API 26)

Хранение данных:
- SQLite (основные данные)
- SharedPreferences (настройки и аутентификация)

Интерфейс:
- ConstraintLayout
- RecyclerView
- Material Design компоненты

## 📸 Скриншоты
📸 Скриншоты


- ![Image](https://github.com/user-attachments/assets/10abc2e2-3716-4a42-805f-b986a9215e12)

- ![Image](https://github.com/user-attachments/assets/d48fbe72-b5e8-448a-8530-e11070018a9a)

- ![Image](https://github.com/user-attachments/assets/367f9224-6c14-440c-9f58-58809c1aefb1)

- ![Image](https://github.com/user-attachments/assets/f9c60663-be6a-40ee-aa34-196484dd409b)


## ⚙ Установка
1. Клонируйте репозиторий:
```bash
git clone https://github.com/Yusi-21/Mobile-Apps.git
```
2. Откройте проект в Android Studio
3. Соберите и запустите приложение

Требования:
  Android Studio 2022.2.1 или новее
  Android SDK 33+
  JDK 11+
