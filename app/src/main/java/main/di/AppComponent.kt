package main.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import main.presentation.MainActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,DomainModule::class,DataModule::class,ViewModelModule::class,ViewModelFactoryModule::class])
interface AppComponent {

    @Inject
    fun injectMainActivity(activity : MainActivity)

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance application: Application
        ) : AppComponent
    }
}