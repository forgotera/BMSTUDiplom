package ru.skillbranch.places.screens.settingsScreen.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.skillbranch.places.R
import ru.skillbranch.places.screens.settingsScreen.SettingsScreenConfigurator
import ru.skillbranch.places.screens.settingsScreen.SettingsViewModel

class SettingsScreen : Fragment() {


    private lateinit var holder: SettingsScreenHolder
    lateinit var model: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.settingsscreen, container, false).also {
        holder = settingsScreenHolder(it)
        SettingsScreenConfigurator.create(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        holder.button.setOnClickListener {
            model.showMainScreen()
        }

    }


}