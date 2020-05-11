package ru.skillbranch.places.screens.mainScreen.presentation.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.places.component.PlaceView

class ViewPagerHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(header: String?, image: Int, info: String?, address: String?) {
        (view as? PlaceView)?.apply {
            this.header = header
            this.imageResource = image
            this.url = info
            this.address = address
        }
    }
}


