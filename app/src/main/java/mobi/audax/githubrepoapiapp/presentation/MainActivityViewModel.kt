package mobi.audax.githubrepoapiapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mobi.audax.githubrepoapiapp.data.model.GithubReponse
import mobi.audax.githubrepoapiapp.domain.repository.RepositoriesRepository
import mobi.audax.githubrepoapiapp.util.Resource
import retrofit2.Response

class MainActivityViewModel(
    private val newsRepository: RepositoriesRepository
) : ViewModel() {
    private val repositories: MutableLiveData<Resource<GithubReponse>> = MutableLiveData()
    val newRepositoryList: LiveData<Resource<GithubReponse>> get() = repositories

    init {
        getRepositories()
    }

    fun getRepositories() = viewModelScope.launch {
        repositories.postValue(Resource.Loading())
        val response = newsRepository.getRepositories()
        repositories.postValue(handleResponse(response))
    }

    private fun handleResponse(response: Response<GithubReponse>): Resource<GithubReponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}














