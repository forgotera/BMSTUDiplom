package ru.skillbranch.places

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import ru.skillbranch.places.dataSource.PlacesFilter
import ru.skillbranch.places.dataSource.RealmProvider
import ru.skillbranch.places.utils.activity

class MainActivity : AppCompatActivity() {

//    val realmProvider = RealmProvider(applicationContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = findNavController(R.id.currentNavHostId)
        controller.graph = controller.navInflater.inflate(R.navigation.main_graph).apply {
            startDestination = R.id.selectScreen
        }
    }
}
