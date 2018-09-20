package skatech.marno.footballmatchapp.Models

import com.google.gson.annotations.SerializedName

data class AwayTeam(
        @SerializedName("strTeamBadge")
        var teamBadge: String? = null
)