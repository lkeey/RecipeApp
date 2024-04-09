package api

import data.CountModel
import data.Receipts
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import kotlinx.coroutines.flow.flow

class Repository {

    private val client = ApiClient().httpClient

    private suspend fun getCountQuery(
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

    private suspend fun getReceipts(
        query: String
    ) : Receipts  = client.get {
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

    fun getCountQueryFlow(query: String) = flow {
        emit(getCountQuery(query))
    }

    fun getReceiptsFlow(query: String) = flow {
        emit(getReceipts(query))
    }
}
