package mobi.audax.githubrepoapiapp.domain.repository

import mobi.audax.githubrepoapiapp.data.api.RetrofitInstance

class RepositoriesRepository() {
    suspend fun getRepositories() = RetrofitInstance.api.getBreakingNews()
}