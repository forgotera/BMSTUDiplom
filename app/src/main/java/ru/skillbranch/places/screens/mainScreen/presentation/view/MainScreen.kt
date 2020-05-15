package ru.skillbranch.places.screens.mainScreen.presentation.view

import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import ru.skillbranch.places.MainActivity
import ru.skillbranch.places.R
import ru.skillbranch.places.screens.mainScreen.presentation.MainScreenConfigurator
import ru.skillbranch.places.screens.mainScreen.presentation.model.PlacesModel
import ru.skillbranch.places.screens.mainScreen.presentation.viewmodel.MainScreenViewModel
import ru.skillbranch.places.utils.dip
import timber.log.Timber

//основной экран приложения тут отображаются три заведения
class MainScreen : Fragment() {

    private lateinit var holder: MainScreenHolder
    lateinit var model: MainScreenViewModel
    private val adapter = ViewPagerAdapter()

    override fun onResume() {
        setData()
        super.onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.mainscreen, container, false).also {

        Timber.plant(Timber.DebugTree())
        holder = mainScreenHolder(it)

        holder.toolbar.setOnMenuItemClickListener {
            model.isSetting = true
            model.showSettings()
            true
        }

        MainScreenConfigurator.create(this)

        (activity as MainActivity)
            .permissionModule
            .checkPermissions(
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ),
                granted = {
                    model.getPlaces()
                }
            )


        model.viewState.observe(viewLifecycleOwner, Observer { setPlaces(it) })
    }



    private fun setData() {
        var (name, image) = model.getNameAndImage()
        if (image != "null") {
            holder.avatar.setImageURI(Uri.parse(image))
        } else {
            holder.avatar.setImageResource(R.drawable.camera)
        }

        name = ", $name"

        holder.textHello.text = "Привет$name"
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu, menu)
    }

    private fun setPlaces(places: MutableList<PlacesModel?>) {
        adapter.values = places
        holder.values.adapter = adapter
    }

}