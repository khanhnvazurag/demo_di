package guide.access.kernel.engine.demo_di.hilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import guide.access.kernel.engine.demo_di.UserRepository
import guide.access.kernel.engine.demo_di.api.ApiMessage
import guide.access.kernel.engine.demo_di.api.ApiService
import guide.access.kernel.engine.demo_di.hilt.Logger
import guide.access.kernel.engine.demo_di.hilt.UserRepositoryImplHilt
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL_CARD
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL_MESSAGE
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL_NOTIFICATION
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL_ORDER
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL_PAYMENT
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    @Named("main")
    fun provideMainRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    @Named("card")
    fun provideCardRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_CARD)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    @Singleton
    @Named("order")
    fun provideOderRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL_ORDER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    @Named("payment")
    fun providePaymentRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL_PAYMENT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    @Named("notification")
    fun provideNotificationRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL_NOTIFICATION)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    @Named("message")
    fun provideMessageRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL_MESSAGE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideApiService(@Named("main") retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideMessageApiService(@Named("message") retrofit: Retrofit): ApiMessage =
        retrofit.create(ApiMessage::class.java)

    //repository
    @Provides
    @Singleton
    fun provideUserRepo(api: ApiService): UserRepository =
        UserRepositoryImplHilt(api)


    @Provides
    @Singleton
    fun provideLogger(): Logger = Logger()
}