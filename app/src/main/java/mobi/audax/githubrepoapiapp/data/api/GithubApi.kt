package mobi.audax.githubrepoapiapp.data.api

import mobi.audax.githubrepoapiapp.data.model.GithubReponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("search/repositories")
    suspend fun getBreakingNews(
        @Query("q")
        language: String = "kotlin",
        @Query("per_page")
        pageNumber: Int = 30,
        @Query("page")
        page: Int = 1
    ): Response<GithubReponse>

}