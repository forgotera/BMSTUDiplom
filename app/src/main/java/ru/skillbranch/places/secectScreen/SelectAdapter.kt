package ru.skillbranch.places.secectScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.places.R

class SelectAdapter : RecyclerView.Adapter<SelectHolder>() {

    val values = listOf<String>("test", "test", "test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.selectitem, parent, false)
        return parent.context.selectHolder(view)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: SelectHolder, position: Int) {
        holder.bind(values[position], "")
    }

}