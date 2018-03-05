package kevinstar.kotlinapp.ui.adapter

import kevinstar.kotlinapp.domain.model.Forecast

/**
 * 作者: KevinStar on 2018/3/5.22:10
 * 邮箱: wednesday9527@gmail.com
 * */
interface OnItemClickListener {
    fun invoke(forecast:Forecast)
    //使用另一种运算符重载的方式来定义方法调用
}