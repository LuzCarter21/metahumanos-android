package com.example.metahumanos.data

import com.google.gson.annotations.SerializedName

data class AgentResponse (

    val results: List<Agents>

)

data class Agents (
    @SerializedName("uuid") val id: String,
    @SerializedName("displayName") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("developerName") val fileName: String,
    @SerializedName("fullPortrait") val detailImageAgentView: String,
    @SerializedName("displayIcon") val mainImageAgentView: String
)