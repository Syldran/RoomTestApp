package com.learning.roomtestapp.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.ksp.generated.module

@Module
@ComponentScan("com.learning.roomtestapp.ui")
class ViewModelModule

val presentationModule = listOf(
    ViewModelModule().module
)