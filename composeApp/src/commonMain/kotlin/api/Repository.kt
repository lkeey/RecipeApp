package api

import data.CountModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow

class Repository {
    suspend fun getCount() : CountModel {
        val response = httpClient.get("https://api.edamam.com/api/recipes/v2?type=public&q=spagetti&app_id=93a8725b&app_key=0f746d5f5b07dc5dd1f954c71b8594ad")
        return response.body()
    }

    fun countFlow() = flow {
        emit(getCount())
    }
}