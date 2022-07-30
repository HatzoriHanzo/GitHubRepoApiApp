package mobi.audax.githubrepoapiapp.data.model

data class GithubReponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)