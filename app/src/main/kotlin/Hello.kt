/**
 * Created by hwanik on 2016. 12. 21..
 */

package com.hwanik.hixguruexample

import android.content.ContentValues.TAG
import android.util.Log

fun formatMessage(name: String): String = "Hello , $name"

fun testNulluble(email:String?, password:String?): String {
    // ? 를 붙여야 null check가 된다. ?를 붙이지 않을 경우 non-null로 인식해서 null값이 오면 에러가 발생한다.
    if (null === email) {
        Log.d(TAG, "email is null")
    } else {
        return email.plus(" is correct")
    }
    var sum = 0
    listOf(1,2,3).filter { it > 0 }.forEach {
        sum+= it
    }
    return sum.toString()
}