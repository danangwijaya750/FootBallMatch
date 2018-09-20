package skatech.marno.footballmatchapp.Models.Adapters
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.event_list.*
import skatech.marno.footballmatchapp.Models.Event
import skatech.marno.footballmatchapp.R

class EventAdp(val context: Context, val events:List<Event>, val listen:(Event)->Unit): RecyclerView.Adapter<EventAdp.ViewHold>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        return ViewHold(LayoutInflater.from(context).inflate(R.layout.event_list, parent, false))
    }

    override fun getItemCount(): Int {
        return events.size
    }
    override fun onBindViewHolder(holder: ViewHold, position: Int) {
        holder.binding(events[position],listen)
    }

    class  ViewHold(override val containerView: View?): RecyclerView.ViewHolder(containerView),LayoutContainer {
        fun binding(event: Event, listen: (Event) -> Unit) {
        dateEvent.text=event.dateEvent
        titleEvent.text=event.strEvent
            homeScore.text=event.intHomeScore
            awayScore.text=event.intAwayScore
        itemView.setOnClickListener{listen(event)}
        }
    }
}