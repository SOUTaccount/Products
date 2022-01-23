package com.stebakov.products.presentation.fragment.phonedetail.characteristics

sealed class Characteristics {
    val name: String
        get() = when (this) {
            is Shop -> "Shop"
            is Details -> "Details"
            is Features -> "Features"
        }
}

object Shop : Characteristics()
object Details : Characteristics()
object Features : Characteristics()