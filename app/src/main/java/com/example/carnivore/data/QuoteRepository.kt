package com.example.carnivore.data

import java.time.LocalDate

object QuoteRepository {

    // The growing CarniCoach Wisdom collection.
    // First quote is fixed as quote #1 so it always appears on day one of the rotation.
    private val quotes = listOf(
        Quote(1, "Eat for nutrition, not for entertainment."),
        Quote(2, "Simplicity is sustainable. The fewer decisions you have to make, the easier consistency becomes."),
        Quote(3, "Your body doesn't need variety, it needs nutrients."),
        Quote(4, "Consistency beats perfection. Show up for your next meal, not your last mistake."),
        Quote(5, "Hunger is not an emergency. Trust the process."),
        Quote(6, "Healing takes time. Give your body the same patience you'd give a friend."),
        Quote(7, "Salt, water, and rest are not optional. They are the foundation.")
    )

    /**
     * Returns a deterministic quote for the given date so every user sees the
     * same quote on the same day, and it stays stable if they reopen the app.
     * Rotates through the full collection before repeating.
     */
    fun getQuoteForDate(date: LocalDate = LocalDate.now()): Quote {
        val index = date.toEpochDay().mod(quotes.size.toLong()).toInt()
        return quotes[index]
    }

    fun getQuoteForToday(): Quote = getQuoteForDate()

    fun allQuotes(): List<Quote> = quotes
}
