package kevinstar.kotlinapp

import org.junit.Test
import java.util.*

/**
 * 作者: KevinStar on 2018/3/5.13:08
 * 邮箱: wednesday9527@gmail.com
 */
class MainActivityTest {

    @Test
    fun onCreate() {
        var person = Person()
        person.name = "Hello"
        person.address = "XiaMen"
        println(person.name)
        println(person.address)


        //调试扩展函数

        val l = mutableListOf<Int>(1,2,3)
        l.swap(0,2)

        for(item:Int in l){
            println(item)
        }
        for (item :Int in l)print(item)



    }

    @Test
    fun testDataClass() {
        val f1 = Forecast(Date(),27.5f,"Shiny day")
        val f2 = f1.copy(temperature = 30.0f)
        print(f2.temperature)
        //多声明
        val (date,temperature,day) = f1;
        print(temperature)
    }

    data class Forecast(val date:Date, val temperature:Float, val details:String )

    class Person{
        var name:String = ""
            get() = this.toString()
            set(value) {
                field = "Name :$value"
            }
        var address:String=""
            get() = this.toString()
            set(value) {
                field = "Address :$value"
            }
    }

    class Address(var name: String){
    }

    fun copyAddress(address : Address):Address{
        val result = Address("Kevin_Star");
        result.name = address.name
        return result
    }

    @Test
    fun loopTest() {
       var hellos = listOf<String>("1",
               "2"
               )
       var hell1 = hellos.mapIndexed{
            index,it-> "Index: $it"
        }
        for(item in hell1) println(item)
    }

    @Test
    fun withFunction() {
        var person = Person()
        with(person){
            print("With:$name")
        }
    }
}