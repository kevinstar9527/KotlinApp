package kevinstar.kotlinapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kevinstar.kotlinapp.R
import kevinstar.kotlinapp.domain.commands.RequestForecastCommand
import kevinstar.kotlinapp.domain.model.Forecast
import kevinstar.kotlinapp.ui.adapter.ForecastListAdapter
import kevinstar.kotlinapp.ui.adapter.OnItemClickListener
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 5/23 -Sunny - 31/17",
            "Mon 5/23 -Sunny - 31/17",
            "Mon 5/23 -Sunny - 31/17",
            "Mon 5/23 -Sunny - 31/17",
            "Mon 5/23 -Sunny - 31/17",
            "Mon 5/23 -Sunny - 31/17"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val tvKotlinTest = this.findViewById(R.id.tv_kotlin_test) as TextView;
        val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        //forecastList.adapter = ForecastListAdapter(items)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread{
                /*匿名类的创建*/
                forecastList.adapter = ForecastListAdapter(result,object:OnItemClickListener{
                    override fun invoke(forecast: Forecast) {
                        longToast("点击了某一项")
                    }

                })
            }

        }


    }

}
