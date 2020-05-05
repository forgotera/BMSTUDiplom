package ru.skillbranch.places.screens.mainScreen.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.places.R
import ru.skillbranch.places.screens.mainScreen.presentation.model.PlacesModel

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerHolder>() {

    var onClick: (() -> Unit)? = null
    var values: List<PlacesModel?> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.viewpageritem, parent, false)
        return parent.context.viewPagerHolder(view, onClick)
    }

    override fun getItemCount(): Int = 3


    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val properties = values[position]?.features?.get(0)?.properties
        val name = properties?.name
        val description = properties?.description
        var url: String? = "Данные отсутсвуеют"
        if (properties?.companyMetaData != null) {
            url = properties.companyMetaData.url
        }

        holder.bind(
            name,
            R.drawable.batut,
            url,
            description
        )
    }
}