package com.example.flutter_application_2

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // 🔑 Получаем API-ключ из ресурсов
        val apiKey = getString(R.string.yandex_mapkit_api_key)
        MapKitFactory.setApiKey(apiKey)
        MapKitFactory.initialize(this)
    }
}