package ru.skillbranch.places

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import ru.skillbranch.places.permissions.InnerPermissionCallback
import ru.skillbranch.places.permissions.PermissionModule

//точко входа
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
        val realmProvider = daggerApplication.daggerMainActivityComponent.getRealmProvider()
        realmProvider.initialization()

        val controller = findNavController(R.id.currentNavHostId)
        var start = R.id.selectScreen
        //если бд не пуста перейти сразу к главном экрану
        if(!realmProvider.isEmpty){
            start = R.id.mainScreen
        }
        controller.graph = controller.navInflater.inflate(R.navigation.main_graph).apply {
            startDestination = start
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



