package guide.access.kernel.engine.demo_di.pattern

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import guide.access.kernel.engine.demo_di.ApiService
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL
import guide.access.kernel.engine.demo_di.utils.PreferenceHelper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(context: Context) {

    private val apiService: ApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)


    private val shared = PreferenceHelper(context.getSharedPreferences(
        PreferenceHelper.PREFS_NAME,
        Context.MODE_PRIVATE
    ))

    private val repo = UserRepositoryImpl(apiService,shared)
    //lặp apiService, shared nếu có thêm repository
    private val commentRepo = ActiveRepositoryImpl(apiService,shared)

    fun provideUserViewModelFactory(): ViewModelProvider.Factory {
        return UserViewModelFactory(repo)
    }

}