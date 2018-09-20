package skatech.marno.footballmatchapp

import android.os.Bundle
import android.os.StrictMode
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*
import skatech.marno.footballmatchapp.Models.AwayTeam
import skatech.marno.footballmatchapp.Models.AwayTeamResponse
import skatech.marno.footballmatchapp.Models.HomeTeam
import skatech.marno.footballmatchapp.Models.HomeTeamResponse
import java.net.URL

class DetailMatch : AppCompatActivity() {
    val homeData:MutableList<HomeTeam> = mutableListOf()
    val awayData:MutableList<AwayTeam> = mutableListOf()
    var homeScore: String? =null
    lateinit var hmData:List<HomeTeam>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        StrictMode.enableDefaults()
        getHomeBadge(intent.getStringExtra("hid"))
        getAwayBadge(intent.getStringExtra("aid"))
        dateMatch.text=intent.getStringExtra("date")
    }

    fun getHomeBadge(id :String){
        val gson=Gson()
        val res:String= URL("https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=$id").readText()
        Log.d("tag","badge team $res")
        val data=gson.fromJson(res,HomeTeamResponse::class.java)
        Log.d("tag1","isi dari data home ${data.teams.size}")
        homeData.addAll(data.teams)
        Log.d("tag3",homeData[0].teamBadge.toString())
        Picasso.get().load(homeData[0].teamBadge.toString()).into(homeBadge)

        if(intent.getStringExtra("hscr")==null) homeScr.text=""
        else homeScr.text=intent.getStringExtra("hscr")
        if(intent.getStringExtra("homeFormat")==null) homeFormation.text=""
        else homeFormation.text=intent.getStringExtra("homeFormat")
        homeTeam.text=intent.getStringExtra("home")
        if(intent.getStringExtra("homeKeeper")==null) homeKeeper.text=""
        else homeKeeper.text=intent.getStringExtra("homeKeeper")
        if(intent.getStringExtra("homeDefend")==null)homeDefend.text=""
        else homeDefend.text=intent.getStringExtra("homeDefend")
        if(intent.getStringExtra("homeMid")==null)homeMid.text=""
        else homeMid.text=intent.getStringExtra("homeMid")
        if(intent.getStringExtra("homeFor")==null) homeFor.text=""
        else homeFor.text=intent.getStringExtra("homeFor")
        if(intent.getStringExtra("hmGoals")==null)homeGoals.text=""
        else homeGoals.text=intent.getStringExtra("hmGoals")
        if(intent.getStringExtra("hmShoot")==null)homeShoot.text=""
        else homeShoot.text=intent.getStringExtra("hmShoot")
    }

    fun getAwayBadge(id:String){
        val gson=Gson()
        val res:String= URL("https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=$id").readText()
        Log.d("tag","badge team $res")
        val data=gson.fromJson(res,AwayTeamResponse::class.java)
        Log.d("tag1","isi dari data home ${data.teams.size}")
        awayData.addAll(data.teams)
        Log.d("tag3",awayData[0].teamBadge.toString())
        Picasso.get().load(awayData[0].teamBadge.toString()).into(awayBadge)
        if(intent.getStringExtra("ascr")==null) awayScr.text=""
        else awayScr.text=intent.getStringExtra("ascr")
        if(intent.getStringExtra("away")==null)awayTeam.text=""
        else awayTeam.text=intent.getStringExtra("away")
        if(intent.getStringExtra("awayFormat")==null)awayFormation.text=""
        else awayFormation.text=intent.getStringExtra("awayFormat")
        if(intent.getStringExtra("awayKeeper")==null)awayKeeper.text=""
        else awayKeeper.text=intent.getStringExtra("awayKeeper")
        if(intent.getStringExtra("awayDefend")==null)awayDefend.text=""
        else awayDefend.text=intent.getStringExtra("awayDefend")
        if(intent.getStringExtra("awayMid")==null)awayMid.text=""
        else awayMid.text=intent.getStringExtra("awayMid")
        if(intent.getStringExtra("awayFor")==null)awayFor.text=""
        else awayFor.text=intent.getStringExtra("awayFor")
        if(intent.getStringExtra("awGoals")==null)awayGoals.text=""
        else awayGoals.text=intent.getStringExtra("awGoals")
        if(intent.getStringExtra("awShoot")==null)awayShoot.text=""
        else awayShoot.text=intent.getStringExtra("awShoot")
    }
}
