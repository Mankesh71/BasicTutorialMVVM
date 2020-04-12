package com.test.mvvmcrashcourse.data

class FakeQuoteDatabase private constructor() {

    var quoteDao = FakeQuoteDao()
        private set

    companion object {
        @Volatile private var instance: FakeQuoteDatabase? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: FakeQuoteDatabase().also { instance = it }
        }
    }

}