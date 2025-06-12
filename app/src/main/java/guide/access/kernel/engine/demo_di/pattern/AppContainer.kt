package guide.access.kernel.engine.demo_di.pattern

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import guide.access.kernel.engine.demo_di.api.ApiCard
import guide.access.kernel.engine.demo_di.api.ApiMessage
import guide.access.kernel.engine.demo_di.api.ApiNotification
import guide.access.kernel.engine.demo_di.api.ApiOrder
import guide.access.kernel.engine.demo_di.api.ApiPayment
import guide.access.kernel.engine.demo_di.api.ApiService
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL_CARD
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL_NOTIFICATION
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL_ORDER
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL_PAYMENT
import guide.access.kernel.engine.demo_di.utils.PreferenceHelper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(context: Context) {

    private fun buildRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val cardApi: ApiCard = buildRetrofit(BASE_URL_CARD).create(ApiCard::class.java)
    val orderApi: ApiOrder = buildRetrofit(BASE_URL_ORDER).create(ApiOrder::class.java)
    val paymentApi: ApiPayment = buildRetrofit(BASE_URL_PAYMENT).create(ApiPayment::class.java)
    val notificationApi: ApiNotification =
        buildRetrofit(BASE_URL_NOTIFICATION).create(ApiNotification::class.java)

    //
    val messageApi: ApiMessage = buildRetrofit(BASE_URL).create(ApiMessage::class.java)


    private val shared = PreferenceHelper(
        context.getSharedPreferences(
            PreferenceHelper.PREFS_NAME,
            Context.MODE_PRIVATE
        )
    )

    val userApi: ApiService = buildRetrofit(BASE_URL).create(ApiService::class.java)

    private val repo = UserRepositoryImpl(userApi, shared)

    fun provideUserViewModelFactory(): ViewModelProvider.Factory {
        return UserViewModelFactory(repo,commentRepo)
    }

    private val commentRepo = ActiveRepositoryImpl(userApi, shared)

}