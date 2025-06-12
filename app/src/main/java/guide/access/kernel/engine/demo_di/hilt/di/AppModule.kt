package guide.access.kernel.engine.demo_di.hilt.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import guide.access.kernel.engine.demo_di.ApiService
import guide.access.kernel.engine.demo_di.hilt.UserRepositoryImplHilt
import guide.access.kernel.engine.demo_di.UserRepository
import guide.access.kernel.engine.demo_di.utils.Constant.BASE_URL
import guide.access.kernel.engine.demo_di.utils.MediaPlayerHelper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideUserRepository(
        api: ApiService
    ): UserRepository = UserRepositoryImplHilt(api)


    @ActivityScoped
    fun provideMediaPlayerHelper(@ActivityContext context: Context): MediaPlayerHelper {
        return MediaPlayerHelper(context)
    }

}