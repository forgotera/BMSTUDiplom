package ru.skillbranch.places.secectScreen.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import ru.skillbranch.places.R
import ru.skillbranch.places.secectScreen.SelectAdapter
import ru.skillbranch.places.secectScreen.SelectScreenConfigurator

class SelectScreen: Fragment() {

    private lateinit var holder:SelectScreenHolder

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.selectscreen,container,false).also {
        holder = selectScreenHolder(it)
        SelectScreenConfigurator.create(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        holder.values.layoutManager = GridLayoutManager(context,2)
        holder.values.adapter = SelectAdapter()


    }


}