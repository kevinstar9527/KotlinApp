package kevinstar.kotlinapp.domain.commands

/**
 * 作者: KevinStar on 2018/3/5.15:32
 * 邮箱: wednesday9527@gmail.com
 */
public interface Command<T>{
    fun execute():T
}