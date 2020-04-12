package com.test.mvvmcrashcourse.utilities

import com.test.mvvmcrashcourse.data.FakeQuoteDatabase
import com.test.mvvmcrashcourse.data.QuoteRepository
import com.test.mvvmcrashcourse.ui.quotes.QuoteViewModelFactory

object InjectorUtils {

    fun provideQuoteViewModelFactory(): QuoteViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeQuoteDatabase.getInstance().quoteDao)
        return QuoteViewModelFactory(quoteRepository = quoteRepository)
    }

}