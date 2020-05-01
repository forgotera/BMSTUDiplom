package ru.skillbranch.places.selectScreen.presentation

import androidx.navigation.NavController
import ru.skillbranch.places.R

interface SelectRouter {
    fun showNext()
}

class SelectRouterImpl(
    private val navigation: NavController
) : SelectRouter {

    override fun showNext() {
        navigation.navigate(R.id.mainScreen)
    }

}