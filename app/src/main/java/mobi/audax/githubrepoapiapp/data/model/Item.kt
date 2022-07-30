package mobi.audax.githubrepoapiapp.data.model

import java.io.Serializable

data class Item(
    val id: Int? = null,
    val description: String,
    val language: String,
    val name: String,
    val owner: Owner,
    val score: Int,
    val url: String,
    val html_url: String
) : Serializable