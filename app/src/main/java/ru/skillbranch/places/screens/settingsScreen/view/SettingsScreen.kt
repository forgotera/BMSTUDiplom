package ru.skillbranch.places.screens.settingsScreen.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.skillbranch.places.R
import ru.skillbranch.places.screens.settingsScreen.SettingsScreenConfigurator
import ru.skillbranch.places.screens.settingsScreen.SettingsViewModel

//экран настроек тут можно изменить имя и выбрать свой аватар
class SettingsScreen : Fragment() {


    private lateinit var holder: SettingsScreenHolder
    lateinit var model: SettingsViewModel
    private val GALLERY_REQUEST = 1
    private var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.settingsscreen, container, false).also {

        holder = settingsScreenHolder(it)
        holder.toolbar.title = "Настройки"
        holder.toolbar.navigationIcon = resources.getDrawable(R.drawable.arrow_back)
        (activity as AppCompatActivity).setSupportActionBar(holder.toolbar)
        holder.toolbar.setNavigationOnClickListener {
            model.back()
        }
        SettingsScreenConfigurator.create(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        holder.imageView.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, GALLERY_REQUEST)
        }

        holder.button.setOnClickListener {
            model.saveNameAndPhoto(holder.editText.text.toString(),imageUri.toString())
            model.showMainScreen()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        imageUri = data?.data
        holder.imageView.setImageURI(imageUri)
    }


}