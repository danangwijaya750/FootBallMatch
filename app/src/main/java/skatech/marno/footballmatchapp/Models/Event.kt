package skatech.marno.footballmatchapp.Models

import com.google.gson.annotations.SerializedName

data class Event(
        @SerializedName("idEvent")
        val idEvent: String,
        val idSoccerXML: String,
        @SerializedName("strEvent")
        val strEvent: String,
        val strFilename: String,
        val strSport: String,
        val idLeague: String,
        val strLeague: String,
        val strSeason: String,
        val strDescriptionEN: Any,
        @SerializedName("strHomeTeam")
        val strHomeTeam: String,
        @SerializedName("strAwayTeam")
        val strAwayTeam: String,
        val intHomeScore: String,
        val intRound: String,
        val intAwayScore: String,
        val intSpectators: Any,
        val strHomeGoalDetails: String,
        val strHomeRedCards: String,
        val strHomeYellowCards: String,
        val strHomeLineupGoalkeeper: String,
        val strHomeLineupDefense: String,
        val strHomeLineupMidfield: String,
        val strHomeLineupForward: String,
        val strHomeLineupSubstitutes: String,
        val strHomeFormation: String,
        val strAwayRedCards: String,
        val strAwayYellowCards: String,
        val strAwayGoalDetails: String,
        val strAwayLineupGoalkeeper: String,
        val strAwayLineupDefense: String,
        val strAwayLineupMidfield: String,
        val strAwayLineupForward: String,
        val strAwayLineupSubstitutes: String,
        val strAwayFormation: String,
        val intHomeShots: Any,
        val intAwayShots: Any,
        val dateEvent: String,
        @SerializedName("strDate")
        val strDate: String,
        val strTime: String,
        val strTVStation: Any,
        val idHomeTeam: String,
        val idAwayTeam: String,
        val strResult: Any,
        val strCircuit: Any,
        val strCountry: Any,
        val strCity: Any,
        val strPoster: Any,
        val strFanart: Any,
        val strThumb: Any,
        val strBanner: Any,
        val strMap: Any,
        val strLocked: String
)