package guide.access.kernel.engine.demo_di.pattern

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import guide.access.kernel.engine.demo_di.UserRepository
import guide.access.kernel.engine.demo_di.model.User
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository,
    private val repositoryActive: ActiveRepositoryImpl,
) : ViewModel() {

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

    fun getData(context: Context){
        repositoryActive.getData(context)
    }

    fun getData(){
        repositoryActive.getData()
    }
}