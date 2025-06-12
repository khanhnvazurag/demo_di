package guide.access.kernel.engine.demo_di.pattern

import android.content.Context
import guide.access.kernel.engine.demo_di.ApiService
import guide.access.kernel.engine.demo_di.utils.PreferenceHelper

class ActiveRepositoryImpl(
    private val api: ApiService,
    private val prefs: PreferenceHelper
) {
    fun getData(context: Context){
        //cần context
    }
    fun getData(){
        //ko cần context
    }
}