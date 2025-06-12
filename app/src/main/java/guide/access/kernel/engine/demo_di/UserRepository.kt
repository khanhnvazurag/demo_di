package guide.access.kernel.engine.demo_di


import guide.access.kernel.engine.demo_di.model.User

interface UserRepository{
    suspend fun getUser(): User
}