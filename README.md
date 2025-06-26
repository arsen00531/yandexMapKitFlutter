# Flutter Yandex MapKit Application

## Настройка проекта

### 1. Клонирование репозитория

```bash
git clone <your-repo-url>
cd flutter_application_2
```

### 2. Установка зависимостей

```bash
flutter pub get
```

### 3. Настройка API ключей

#### Android local.properties:

1. Скопируйте файл `android/local.properties.example` в `android/local.properties`
2. Замените `your_yandex_mapkit_api_key_here` на ваш API ключ Yandex MapKit

#### Android secrets.xml:

1. Скопируйте файл `secrets.xml.example` в `android/app/src/main/res/values/secrets.xml`
2. Замените `your_yandex_mapkit_api_key_here` на ваш API ключ Yandex MapKit

### 4. Получение API ключа Yandex MapKit

1. Зарегистрируйтесь на [developer.tech.yandex.ru](https://developer.tech.yandex.ru/)
2. Создайте новое приложение
3. Получите API ключ для MapKit

### 5. Запуск приложения

```bash
flutter run
```

## ⚠️ Важно для разработчиков

- **НИКОГДА** не коммитьте файлы с API ключами:
  - `android/local.properties`
  - `android/app/src/main/res/values/secrets.xml`
  - `.env`
- Используйте только `.example` файлы в репозитории
- API ключи должны быть в `.gitignore`

## Структура проекта

- `lib/` - Основной код приложения
- `lib/services/` - Сервисы (WebSocket и др.)
- `assets/` - Ресурсы приложения
- `android/local.properties.example` - Пример конфигурации Android
