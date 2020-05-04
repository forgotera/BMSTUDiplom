package ru.skillbranch.places

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    private lateinit var daggerApplication: DaggerApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        daggerApplication = DaggerApplication.get(this)
        //init dataBase
        daggerApplication.daggerMainActivityComponent.getRealmProvider().initialization()

        val controller = findNavController(R.id.currentNavHostId)
        controller.graph = controller.navInflater.inflate(R.navigation.main_graph).apply {
            startDestination = R.id.selectScreen
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //close DataBase
        daggerApplication.daggerMainActivityComponent.getRealmProvider().close()
    }
}



