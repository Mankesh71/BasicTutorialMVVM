package com.test.mvvmcrashcourse.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.test.mvvmcrashcourse.R
import com.test.mvvmcrashcourse.data.Quote
import com.test.mvvmcrashcourse.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        setupUi()
    }

    private fun setupUi() {
        toolbar.setTitle(R.string.app_name)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        val factory = InjectorUtils.provideQuoteViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(QuoteViewModel::class.java)

        viewModel.getQuote().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            text_view_quotes.text = stringBuilder.toString()
        })
        button_add_quote.setOnClickListener {
            val quote = Quote(quoteText = edit_text_quote.text.toString().trim(), quoteAuthor = edit_text_author.text.toString().trim())
            viewModel.addQuote(quote)
            edit_text_quote.setText("")
            edit_text_author.setText("")
        }
    }
}
