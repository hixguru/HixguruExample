package com.hwanik.hixguruexample.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hwanik.hixguruexample.R
import com.jakewharton.rxbinding.view.RxView
import com.jakewharton.rxbinding.widget.RxTextView
import kotlinx.android.synthetic.main.activity_kotlin.*
import network.RedditNewsResponse
import network.RestApi
import rx.Observable
import rx.Subscription
import rx.schedulers.Schedulers

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val tt = getRedditApi(et_reddit_after.text.toString())
        Log.d("tta", tt)
        tv_reddit_result.text = tt
        val sub: Subscription =
                RxTextView.textChanges(et_reddit_after)
                        .filter { it -> it.length >= 3 }
                        .subscribe {
                            Log.d("dd", "왜 안타징")
                            Log.d("reesult", getRedditApi(it.toString()))
                            tv_reddit_result.text = getRedditApi(it.toString())
                        }
    }

    fun getRedditApi(after: String): String {
        val restApi: RestApi = RestApi()
        var test: String = ""

        val observable: Observable<RedditNewsResponse> = restApi.getNews(after, "10")
        observable
                .subscribeOn(Schedulers.io())
                .subscribe { Unit.apply { it.data.children.map {
                    test += it.data.title + '\n'
                } } }
        return test
    }
}

