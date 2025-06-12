package guide.access.kernel.engine.demo_di.hilt.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import guide.access.kernel.engine.demo_di.data.SharedPreferencesManager
import guide.access.kernel.engine.demo_di.utils.MediaPlayerHelper

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    @ActivityScoped
    fun provideMediaPlayerHelper(@ActivityContext context: Context): MediaPlayerHelper {
        return MediaPlayerHelper(context)
    }

    @Provides
    @ActivityScoped
    fun provideSharedPreference(@ActivityContext context: Context): SharedPreferencesManager {
        return SharedPreferencesManager(context)
    }
}