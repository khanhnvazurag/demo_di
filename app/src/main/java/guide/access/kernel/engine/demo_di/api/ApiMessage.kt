package guide.access.kernel.engine.demo_di.api

import guide.access.kernel.engine.demo_di.model.User
import retrofit2.http.GET

interface ApiMessage {

    @GET("/posts/1")
    suspend fun fetchUser(): User
}