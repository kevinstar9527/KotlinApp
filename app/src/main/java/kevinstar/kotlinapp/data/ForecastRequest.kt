package kevinstar.kotlinapp.data

import com.google.gson.Gson

/**
 * 作者: KevinStar on 2018/3/5.15:24
 * 邮箱: wednesday9527@gmail.com
 */
class ForecastRequest(val zipCode:String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q="
    }
    fun executed(): ForecastResult {
        val forecastJsonStr = java.net.URL(COMPLETE_URL +zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}