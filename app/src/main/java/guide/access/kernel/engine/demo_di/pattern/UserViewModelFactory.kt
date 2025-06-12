package guide.access.kernel.engine.demo_di.pattern

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import guide.access.kernel.engine.demo_di.UserRepository

class UserViewModelFactory(
    private val repository: UserRepository,
    private val repositoryActive: ActiveRepositoryImpl
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository,repositoryActive) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}