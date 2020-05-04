package ru.skillbranch.places.screens.mainScreen.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.places.R
import ru.skillbranch.places.screens.mainScreen.presentation.model.PlacesModel

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerHolder>() {

    var onClick: (() -> Unit)? = null
    var values: PlacesModel? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.viewpageritem, parent, false)
        return parent.context.viewPagerHolder(view, onClick)
    }

    override fun getItemCount(): Int  = 3


    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.bind("test",R.drawable.batut,"jump","дом кукушкина")
    }
}