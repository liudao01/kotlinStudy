package com.example.kotlin.study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.nio.file.Files.find

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //导航使用 总控制器 设置导航
        val navView: BottomNavigationView  = findViewById(R.id.nav_view)

        //配置
        val appBarConfiguration:AppBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_host_fragment,
            R.id.navigation_collect,
            R.id.navigation_personal
        ).build()

        //控制器
        val navController : NavController = Navigation.findNavController(this,R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

}