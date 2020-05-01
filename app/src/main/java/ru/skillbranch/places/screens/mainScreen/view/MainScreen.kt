package ru.skillbranch.places.screens.mainScreen.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.skillbranch.places.R
import ru.skillbranch.places.screens.mainScreen.MainScreenConfigurator

class MainScreen: Fragment() {

    private lateinit var holder:MainScreenHolder

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  = inflater.inflate(R.layout.mainscreen,container,false).also {

        holder = mainScreenHolder(it)
        MainScreenConfigurator.create(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ViewPagerAdapter()
        holder.values.adapter = adapter



    }

}