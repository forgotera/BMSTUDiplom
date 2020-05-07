package ru.skillbranch.places

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import ru.skillbranch.places.permissions.InnerPermissionCallback
import ru.skillbranch.places.permissions.PermissionModule

class MainActivity : AppCompatActivity() {

    private lateinit var daggerApplication: DaggerApplication
    val permissionModule by lazy {
        PermissionModule(InnerPermissionCallback(this))
    }

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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        permissionModule.onRequestPermissionsResult(requestCode, permissions, grantResults)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}



