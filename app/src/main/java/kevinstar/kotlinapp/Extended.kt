package kevinstar.kotlinapp

import android.content.Context
import android.widget.Toast

/**
 * 作者: KevinStar on 2018/3/5.14:01
 * 邮箱: wednesday9527@gmail.com
 */
fun Context.toast(message:String,length:Int = Toast.LENGTH_LONG) = Toast.makeText(this,message,length).show()

fun MutableList<Int>.swap(index1:Int,index2:Int){
    val temp = this[index1]
    this[index1]=this[index2]
    this[index2]=temp
}