package com.test.mvvmcrashcourse.ui.quotes

import androidx.lifecycle.ViewModel
import com.test.mvvmcrashcourse.data.Quote
import com.test.mvvmcrashcourse.data.QuoteRepository

class QuoteViewModel(private  val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuote() = quoteRepository.getQuote()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

}