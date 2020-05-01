package ru.skillbranch.places.screens.selectScreen.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import ru.skillbranch.places.R
import ru.skillbranch.places.dialog.Dialog
import ru.skillbranch.places.dictionary.MAIN_DICTIONARY
import ru.skillbranch.places.screens.selectScreen.presentation.SelectScreenConfigurator
import ru.skillbranch.places.screens.selectScreen.presentation.SelectAdapter
import ru.skillbranch.places.screens.selectScreen.presentation.viewModel.SelectScreenViewModel

class SelectScreen : Fragment() {

    private lateinit var holder: SelectScreenHolder
    lateinit var model: SelectScreenViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.selectscreen, container, false).also {

        holder = selectScreenHolder(it)
        SelectScreenConfigurator.create(this)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        holder.values.layoutManager = GridLayoutManager(context, 2)
        val adapter =
            SelectAdapter()
        Dialog().show(activity?.supportFragmentManager!!,"sdf")
        holder.values.adapter = adapter

        //значения из общейго мапа - в перспективе бд
        adapter.values = MAIN_DICTIONARY.keys.toMutableList()
        adapter.images = MAIN_DICTIONARY.values.toMutableList()

        adapter.onClick = { value ->
            model.check(value)
        }

        holder.button.setOnClickListener {
            model.takeSelected()
            model.showNext()
        }

    }


}