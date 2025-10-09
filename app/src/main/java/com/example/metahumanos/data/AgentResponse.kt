package com.example.metahumanos.data

import com.google.gson.annotations.SerializedName

data class AgentsResponse (
    val status: Int,
    val data: List<Agent>

)

data class AgentResponse(
    val status: Int,
    val data: Agent
)

data class Agent (
    @SerializedName("uuid") val id: String,
    @SerializedName("displayName") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("developerName") val fileName: String,
    @SerializedName("fullPortrait") val detailImageAgentView: String,
    @SerializedName("displayIcon") val mainImageAgentView: String
)