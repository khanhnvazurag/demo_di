package guide.access.kernel.engine.demo_di.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import guide.access.kernel.engine.demo_di.utils.Constant.KEY_FIRST_FLOW
import guide.access.kernel.engine.demo_di.utils.Constant.KEY_SHARED

class SharedPreferencesManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences(KEY_SHARED, Context.MODE_PRIVATE)

    fun setFirstFlow(value: Boolean) {
        prefs.edit { putBoolean(KEY_FIRST_FLOW, value) }
    }

    fun getFirstFlow(): Boolean {
        return prefs.getBoolean(KEY_FIRST_FLOW, true)
    }


}