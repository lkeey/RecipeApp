package api

import data.CountModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import kotlinx.coroutines.flow.flow

class Repository {

    private val client = ApiClient().httpClient

    suspend fun getCount() : CountModel =
        client.get("https://api.edamam.com/api/recipes/v2?type=public&q=spagetti&app_id=93a8725b&app_key=0f746d5f5b07dc5dd1f954c71b8594ad").body()

    suspend fun getCountQuery(
        query: String
    ) : CountModel = client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.edamam.com"
                parameters.append("type", "public")
                parameters.append("q", query)
                parameters.append("app_id", "93a8725b")
                parameters.append("app_key", "0f746d5f5b07dc5dd1f954c71b8594ad")
                path("api/recipes/v2")
            }
        }.body()

    fun countFlow() = flow {
        emit(getCount())
    }
}