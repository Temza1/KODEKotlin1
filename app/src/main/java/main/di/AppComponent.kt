package main.di

import dagger.Component

@Component(modules = [AppModule::class,DomainModule::class,DataModule::class])
interface AppComponent {

}