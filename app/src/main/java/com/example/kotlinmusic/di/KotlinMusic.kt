package com.example.kotlinmusic.di

import android.app.Application
import androidx.room.Room
import com.example.kotlinmusic.data.database.AppDatabase
import com.example.kotlinmusic.network.ApiInterface
import com.example.kotlinmusic.util.Constants
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class KotlinMusic : Application() {

    private val appModule = module {
        single {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }

        factory { get<Retrofit>().create(ApiInterface::class.java) }

        single {
            Room.databaseBuilder(get(), AppDatabase::class.java, "kotlin_music_db")
                .fallbackToDestructiveMigration()
                .build()
        }

        single {
            get<AppDatabase>().favoriteTrackDao()
        }
    }


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KotlinMusic)
            modules(appModule)
        }
    }
}

