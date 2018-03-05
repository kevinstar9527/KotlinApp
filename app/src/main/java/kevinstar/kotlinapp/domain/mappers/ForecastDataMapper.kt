package kevinstar.kotlinapp.domain.mappers

import kevinstar.kotlinapp.data.Forecast
import kevinstar.kotlinapp.data.ForecastResult
import kevinstar.kotlinapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kevinstar.kotlinapp.domain.model.Forecast as ModelForest

/**
 * 作者: KevinStar on 2018/3/5.15:38
 * 邮箱: wednesday9527@gmail.com
 */
public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }
    /**
     * 将Gson中的实体类转换为 领域MODEL
     * */
    private fun convertForecastListToDomain(list:List<Forecast>):List<ModelForest>{
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForest {
        return ModelForest(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }
}