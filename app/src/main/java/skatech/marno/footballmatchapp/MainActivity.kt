package skatech.marno.footballmatchapp


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

var content:FrameLayout?=null
    val navigateListener = object :BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            if(item.itemId==R.id.pastEvent){
                startPast()
                return true
            }else if(item.itemId==R.id.nextEvent){
                startNext()
                return true
            }
            return false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigate.setOnNavigationItemSelectedListener (navigateListener)
    }
    fun startPast(){
        val intent = Intent(this,PastMatch::class.java)
        startActivity(intent)
    }
    fun startNext(){
        val intent = Intent(this,NextMatch::class.java)
        startActivity(intent)
    }

}
