package guide.access.kernel.engine.demo_di.hilt

import guide.access.kernel.engine.demo_di.ApiService
import guide.access.kernel.engine.demo_di.UserRepository
import guide.access.kernel.engine.demo_di.model.User
import javax.inject.Inject

class UserRepositoryImplHilt @Inject constructor(
    private val api: ApiService
) : UserRepository {
    override suspend fun getUser(): User {
        return api.fetchUser()
    }
}