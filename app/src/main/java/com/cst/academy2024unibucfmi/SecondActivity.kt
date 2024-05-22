package com.cst.academy2024unibucfmi

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.cst.academy2024unibucfmi.managers.SharedPrefsManager
import com.cst.academy2024unibucfmi.utils.extensions.logErrorMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {

    private lateinit var splashScreen: SplashScreen
    private var isAppInit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        setupSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            setupNavigation()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        "onDestroy()".logErrorMessage()
    }

    private fun setupNavigation() {
        SharedPrefsManager.readToken()?.let {
            navigateToProducts()
        }

        isAppInit = true
    }

    private fun navigateToProducts() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.productsFragment)
    }

    private fun setupSplashScreen() {
        splashScreen = installSplashScreen().apply {
            // Behaves like observable, used to check if splash screen should be keep or not
            setKeepOnScreenCondition {
                !isAppInit
            }
            setOnExitAnimationListener { sp ->
                sp.remove() // Remove splash screen
            }
        }
    }
}