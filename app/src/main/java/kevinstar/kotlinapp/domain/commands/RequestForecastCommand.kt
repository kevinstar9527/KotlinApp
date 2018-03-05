package kevinstar.kotlinapp.domain.commands

import kevinstar.kotlinapp.data.ForecastRequest
import kevinstar.kotlinapp.domain.mappers.ForecastDataMapper
import kevinstar.kotlinapp.domain.model.ForecastList

/**
 * 作者: KevinStar on 2018/3/5.16:05
 * 邮箱: wednesday9527@gmail.com
 */
public class RequestForecastCommand(val zipCode:String):Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.executed())
    }
}