package com.alwaysbaked.population.model

import com.google.gson.annotations.SerializedName

data class Root(
        @SerializedName("worldpopulation") val worldpopulation: List<Worldpopulation>
)