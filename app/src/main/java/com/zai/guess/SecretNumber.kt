package com.zai.guess

class SecretNumber {
    val guess_count =10
    val secretNumber = (Math.random()*guess_count + 1).toInt()
    var count = 0
    fun different(number:Int):Int{
        count++
        return number - secretNumber
    }
}

fun main() {
    val secretNumber = SecretNumber()
    println(secretNumber.secretNumber)
    println("${secretNumber
        .different(5)}, 你猜了第 ${secretNumber.count}次 ") // 5- secretNumber 結果

}