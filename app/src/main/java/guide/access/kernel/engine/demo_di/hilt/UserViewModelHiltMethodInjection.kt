package guide.access.kernel.engine.demo_di.hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import guide.access.kernel.engine.demo_di.model.User
import guide.access.kernel.engine.demo_di.UserRepository
import kotlinx.coroutines.launch
import javax.annotation.Nullable
import javax.inject.Inject

@HiltViewModel
class UserViewModelHiltMethodInjection : ViewModel(){

    private lateinit var repository: UserRepository

    @Inject
    fun initRepository(repository: UserRepository) {
        this.repository = repository
    }

    private var logger: Logger? = null

    @Inject
    fun initLogger(@Nullable logger: Logger?) {
        this.logger = logger
    }

    fun track(event: String) {
        logger?.log(event)
    }

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    fun loadUser() {
        viewModelScope.launch {
            try {
                val result = repository.getUser()
                _user.value = result
            } catch (_: Exception) {
            }
        }
    }
}