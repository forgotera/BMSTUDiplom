package ru.skillbranch.places.screens.mainScreen.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.places.R
import ru.skillbranch.places.dataSource.PlacesFilter
import ru.skillbranch.places.dictionary.MAIN_DICTIONARY
import ru.skillbranch.places.screens.mainScreen.presentation.model.PlacesModel

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerHolder>() {

    var values: List<PlacesModel?> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder =
        ViewPagerHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.viewpageritem, parent, false)
        )

    override fun getItemCount(): Int = PlacesFilter.TAKES_PLACES


    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val request = values[position]?.properties?.responseMetadata?.searchRequest?.request
        val found = values[position]?.properties?.responseMetadata?.searchResponse?.found
        var name: String? = ""
        var description: String? = ""
        var url: String? = "Данные отсутсвуют"

        //если элементы найдены
        if (found != 0) {

            val properties = values[position]?.features?.get(0)?.properties
            name = properties?.name
            description = properties?.description

            if (properties?.companyMetaData != null) {
                url = properties.companyMetaData.url
            }
        }

        holder.bind(
            name,
            MAIN_DICTIONARY[request] ?: R.drawable.empty,
            url,
            description
        )
    }
}