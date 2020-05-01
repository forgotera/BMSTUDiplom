package ru.skillbranch.places.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import ru.skillbranch.places.R


class Dialog : DialogFragment() {

    private lateinit var holder: DialogHolder


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.dialog, container, false).also {

        holder = dialogHolder(it)
        //todo изменить картинку
        holder.imageView.setImageResource(R.drawable.batut)
        holder.button.setOnClickListener {
            dismiss()
        }
    }
}