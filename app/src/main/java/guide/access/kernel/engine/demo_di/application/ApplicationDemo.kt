package guide.access.kernel.engine.demo_di.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import guide.access.kernel.engine.demo_di.pattern.AppContainer

@HiltAndroidApp
class ApplicationDemo: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppContainer(applicationContext)
    }
}