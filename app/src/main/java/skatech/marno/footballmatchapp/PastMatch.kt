package skatech.marno.footballmatchapp

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_past_match.*
import skatech.marno.footballmatchapp.Models.Adapters.EventAdp
import skatech.marno.footballmatchapp.Models.Event
import skatech.marno.footballmatchapp.Models.EventResponse
import java.net.URL
import java.util.logging.Logger

class PastMatch : AppCompatActivity(){



    private  var event:MutableList<Event> = mutableListOf()
    lateinit var eventAdapter: EventAdp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StrictMode.enableDefaults()
        setContentView(R.layout.activity_past_match)
        eventAdapter= EventAdp(this, event) {
            val intent = Intent(this, DetailMatch::class.java)
            intent.putExtra("date",it.dateEvent)
            intent.putExtra("homeFormat", it.strHomeFormation)
            intent.putExtra("awayFormat", it.strAwayFormation)
            intent.putExtra("hscr", it.intHomeScore)
            intent.putExtra("ascr", it.intAwayScore)
            intent.putExtra("home",it.strHomeTeam)
            intent.putExtra("away",it.strAwayTeam)
            intent.putExtra("hid", it.idHomeTeam)
            intent.putExtra("aid", it.idAwayTeam)
            intent.putExtra("homeKeeper",it.strHomeLineupGoalkeeper)
            intent.putExtra("homeDefend",it.strHomeLineupDefense)
            intent.putExtra("homeMid",it.strHomeLineupMidfield)
            intent.putExtra("homeFor",it.strHomeLineupForward)
            intent.putExtra("awayKeeper",it.strAwayLineupGoalkeeper)
            intent.putExtra("awayDefend",it.strAwayLineupDefense)
            intent.putExtra("awayMid",it.strAwayLineupMidfield)
            intent.putExtra("awayFor",it.strAwayLineupForward)
            intent.putExtra("hmGoals",it.strHomeGoalDetails)
            intent.putExtra("awGoals",it.strAwayGoalDetails)
            if(it.intHomeShots==null){ intent.putExtra("hmShoot","-")
            }else { intent.putExtra("hmShoot", it.intHomeShots.toString()) }
            if(it.intAwayShots==null){
            intent.putExtra("awShoot","-")
            }else{intent.putExtra("awShoot",it.intAwayShots.toString()) }

            startActivity(intent)
        }
        val linearLayoutManager=LinearLayoutManager(this)
        linearLayoutManager.orientation=LinearLayoutManager.VERTICAL
        recPast.layoutManager=linearLayoutManager
        getData()
        recPast.adapter=eventAdapter

    }
    fun getData(){
        val gson=Gson()
        val data=gson.fromJson(sendRequest("https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328"), EventResponse::class.java)
        Logger.getLogger(this.javaClass.name).warning(data.toString())
        showList(data.events)

    }
    fun sendRequest(url:String):String{
        return URL(url).readText()
    }
    fun showList(data: List<Event>) {
        event.clear()
        event.addAll(data)
        eventAdapter.notifyDataSetChanged()
    }
}
