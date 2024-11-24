package com.hvyas.architectures.di

import android.content.Context
import com.hvyas.architectures.common.ExpenseDb
import com.hvyas.architectures.mvi.data.dao.MviExpenseDao
import com.hvyas.architectures.mvi.data.repository.MviExpenseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideExpenseDb(@ApplicationContext appContext: Context) = ExpenseDb.getExpenseDb(appContext)

    @Singleton
    @Provides
    fun provideExpenseDao(expenseDb: ExpenseDb) = expenseDb.getMviExpenseDao()

    @Singleton
    @Provides
    fun provideMviExpenseRepository(expenseDao: MviExpenseDao) = MviExpenseRepository(expenseDao)

}