package kevinstar.kotlinapp.domain.model


/**
 * 作者: KevinStar on 2018/3/5.15:34
 * 邮箱: wednesday9527@gmail.com
 */
data class ForecastList(val city:String,val country:String,val dailyForecast:List<Forecast>){
    /**
     * 操作符重载
    * */
    operator fun get(position:Int):Forecast = dailyForecast[position]
    fun size():Int = dailyForecast.size
}