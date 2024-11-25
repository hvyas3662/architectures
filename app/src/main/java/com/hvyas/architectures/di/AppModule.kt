package com.hvyas.architectures.di

import android.content.Context
import com.hvyas.architectures.common.ExpenseDb
import com.hvyas.architectures.mvi.data.dao.MviExpenseDao
import com.hvyas.architectures.mvi.data.repository.MviExpenseRepository
import com.hvyas.architectures.mvvm.data.dao.MvvmExpenseDao
import com.hvyas.architectures.mvvm.data.repository.MvvmExpenseRepository
import com.hvyas.architectures.mvvm_clean.data.dao.CleanMvvmExpenseDao
import com.hvyas.architectures.mvvm_clean.data.repository.CleanMvvmExpenseRepositoryImpl
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
    fun provideMviExpenseDao(expenseDb: ExpenseDb) = expenseDb.getMviExpenseDao()

    @Singleton
    @Provides
    fun provideMviExpenseRepository(expenseDao: MviExpenseDao) = MviExpenseRepository(expenseDao)

    @Singleton
    @Provides
    fun provideMvvmExpenseDao(expenseDb: ExpenseDb) = expenseDb.getMvvmExpenseDao()

    @Singleton
    @Provides
    fun provideMvvmExpenseRepository(expenseDao: MvvmExpenseDao) = MvvmExpenseRepository(expenseDao)

    @Singleton
    @Provides
    fun provideCleanMvvmExpenseDao(expenseDb: ExpenseDb) = expenseDb.getCleanMvvmExpenseDao()

    @Singleton
    @Provides
    fun provideCleanMvvmExpenseRepository(expenseDao: CleanMvvmExpenseDao) = CleanMvvmExpenseRepositoryImpl(expenseDao)

}