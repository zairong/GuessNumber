package com.zai.guess

import java.util.*

class SecretNumber {
    val guess_count =10
    // val secretNumber = (Math.random()*guess_count + 1).toInt()
    var secretNumber = Random().nextInt(10)+1
    var count = 0
    fun different(number:Int):Int{
        count++
        return number - secretNumber
    }
    fun reset(){
        secretNumber = Random().nextInt(10)+1
        count = 0
    }
}

fun main() {
    val secretNumber = SecretNumber()
    println(secretNumber.secretNumber)
    println("${secretNumber
        .different(5)}, 你猜了第 ${secretNumber.count}次 ") // 5- secretNumber 結果

}