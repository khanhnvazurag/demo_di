package guide.access.kernel.engine.demo_di.pattern


import guide.access.kernel.engine.demo_di.api.ApiService
import guide.access.kernel.engine.demo_di.UserRepository
import guide.access.kernel.engine.demo_di.model.User
import guide.access.kernel.engine.demo_di.utils.PreferenceHelper

class UserRepositoryImpl(
    private val api: ApiService,
    private val prefs: PreferenceHelper
) : UserRepository {
    override suspend fun getUser(): User = api.fetchUser()
}