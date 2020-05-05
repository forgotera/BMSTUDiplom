package ru.skillbranch.places.screens.mainScreen.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import ru.skillbranch.places.R
import ru.skillbranch.places.screens.mainScreen.presentation.MainScreenConfigurator
import ru.skillbranch.places.screens.mainScreen.presentation.model.PlacesModel
import ru.skillbranch.places.screens.mainScreen.presentation.viewmodel.MainScreenViewModel
import timber.log.Timber

class MainScreen : Fragment() {

    private lateinit var holder: MainScreenHolder
    lateinit var model: MainScreenViewModel
    private val adapter = ViewPagerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.mainscreen, container, false).also {

        Timber.plant(Timber.DebugTree())
        holder = mainScreenHolder(it)
        MainScreenConfigurator.create(this)
        model.getPlaces()
        model.viewState.observe(viewLifecycleOwner, Observer { setPlaces(it) })
    }

    private fun setPlaces(places: MutableList<PlacesModel?>) {
        adapter.values = places
        holder.values.adapter = adapter
    }

}