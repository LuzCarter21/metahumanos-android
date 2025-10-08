package com.example.metahumanos.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface AgentService {

    @GET("agents")
    suspend fun allAgents(): List<Agents>

    @GET("/{id}")
    suspend fun getAgentById(@Path("id")id: String): Agents

    companion object {
        fun getInstance(): AgentService{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://valorant-api.com/v1/agents/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(AgentService::class.java)
        }
    }

}