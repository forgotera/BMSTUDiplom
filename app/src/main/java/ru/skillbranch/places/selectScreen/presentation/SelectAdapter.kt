package ru.skillbranch.places.selectScreen.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.places.R

class SelectAdapter : RecyclerView.Adapter<SelectHolder>() {

    var values = listOf<String>()
    var images = listOf<Int>()


    var  onClick: ((String)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.selectitem, parent, false)
        return parent.context.selectHolder(view,onClick)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: SelectHolder, position: Int) {
        holder.bind(values[position], images[position])
    }

}