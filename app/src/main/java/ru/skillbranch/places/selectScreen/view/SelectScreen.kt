package ru.skillbranch.places.selectScreen.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import ru.skillbranch.places.R
import ru.skillbranch.places.selectScreen.SelectAdapter
import ru.skillbranch.places.selectScreen.SelectScreenConfigurator

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
        val adapter = SelectAdapter()
        holder.values.adapter = adapter

        adapter.onClick = {
        }
        holder.button.setOnClickListener {
            //todo show new screen
        }


    }


}