package kevinstar.kotlinapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kevinstar.kotlinapp.R
import kevinstar.kotlinapp.domain.model.Forecast
import kevinstar.kotlinapp.domain.model.ForecastList
import org.jetbrains.anko.find

/**
 * 作者: KevinStar on 2018/3/5.12:44
 * 邮箱: wednesday9527@gmail.com
 */
class ForecastListAdapter (val items:ForecastList,val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_forecast,parent,false)
        return ViewHolder(view,onItemClickListener)
    }

    override fun getItemCount(): Int {
        return items.size()
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(items[position])
    }

    class ViewHolder(val view:View,val itemClickListener: OnItemClickListener):RecyclerView.ViewHolder(view){
        private val iconView:ImageView
        private val dateView:TextView
        private val descriptionView:TextView
        private val maxTemperatureView:TextView
        private val minTemperatureView:TextView
        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }


        fun bind(item:Forecast){
            dateView.text = item.date
            descriptionView.text = item.description
            maxTemperatureView.text = item.high.toString()
            minTemperatureView.text = item.low.toString()

            view.setOnClickListener {
                itemClickListener.invoke(item)
            }
        }

    }
}