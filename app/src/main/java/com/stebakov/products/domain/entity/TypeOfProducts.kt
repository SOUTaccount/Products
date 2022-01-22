package com.stebakov.products.domain.entity

import android.view.View
import androidx.annotation.DrawableRes
import com.stebakov.products.R

sealed class TypeOfProducts {
    val name: String
        get() = when (this) {
            is Phones -> "Phones"
            is Computers -> "Computer"
            is Health -> "Health"
            is Books -> "Books"
            is Gifts -> "Gifts"
            is Sport -> "Sport"
        }
    val drawable: Int
        get() = when (this) {
            is Phones -> R.drawable.outline_phone_iphone_24
            is Computers -> R.drawable.outline_computer_24
            is Health -> R.drawable.outline_health_and_safety_24
            is Books -> R.drawable.outline_library_books_24
            is Gifts -> R.drawable.outline_card_giftcard_24
            is Sport -> R.drawable.outline_fitness_center_24
        }
}

object Phones : TypeOfProducts()
object Computers : TypeOfProducts()
object Health : TypeOfProducts()
object Books : TypeOfProducts()
object Gifts : TypeOfProducts()
object Sport : TypeOfProducts()