package skatech.marno.footballmatchapp

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_past_match.*
import skatech.marno.footballmatchapp.Models.Adapters.EventAdp
import skatech.marno.footballmatchapp.Models.Event
import skatech.marno.footballmatchapp.Models.EventResponse
import java.net.URL

class pastMatchFrag : Fragment() {
    private  var event:MutableList<Event> = mutableListOf()
    lateinit var eventAdapter: EventAdp
    lateinit var linMan:LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.activity_past_match, container, false)
        linMan= LinearLayoutManager(this.context?.applicationContext)
        linMan.orientation= LinearLayoutManager.VERTICAL
        eventAdapter= EventAdp(this.context!!.applicationContext, event) {
            val intent = Intent(this.context!!.applicationContext, DetailMatch::class.java)
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
            recPast.layoutManager=linMan
            getData()
            recPast.adapter=eventAdapter
        }
        return rootView
    }
fun init(){

}
    fun getData(){
        val gson=Gson()
        val data=gson.fromJson(sendRequest("https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328"), EventResponse::class.java)
        Log.d("log2",data.toString())
        showList(data.events)
        Log.d("log1",data.events[0].dateEvent)
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
