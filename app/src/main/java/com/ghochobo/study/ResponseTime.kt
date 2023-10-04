/**********************************
 * Name : ResponseTime.kt
 * Author : HaeChan Gho
 * Introduction : Page for Response Time Test.
 ********************************** */

package com.ghochobo.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_response_time.*
import java.util.concurrent.ThreadLocalRandom


class ResponseTime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_response_time)
        startGame()
    }

    fun startGame() {
        val button = findViewById<Button>(R.id.touchbtn)
        val view = findViewById<View>(R.id.view)
        val waitText = findViewById<View>(R.id.waitText)
        val green = findViewById<View>(R.id.Green)
        view.visibility = View.GONE
        Green.visibility = View.GONE
        waitText.visibility = View.GONE


        button.setOnClickListener{
            // 버튼 클릭 시 버튼이 사라지고 붉은색 화면과 Wait for Green 텍스트 보이게 함
            touchbtn.visibility = View.GONE
            view.visibility = View.VISIBLE
            waitText.visibility = View.VISIBLE
            greenTime()
        }
    }
    // 화면을 녹색으로 바꾸며 시간을 재는 함수
    fun greenTime() {
        // 2~ 5초 사이 랜덤한 시간에 화면의 색상이 바뀌고
        // 바뀐 순간부터 시간을 체크하여 사용자가 터치하기까지를 체크함
        // 사용자가 터치하면 터치하기까지 걸린 시간을 ms단위로 나타내 줌
        
        

        val randtime = (2..5).random() // 1. 2초~5 사이 랜덤값 가져오기
        Handler(Looper.getMainLooper()).postDelayed({ // 2. 랜덤값만큼 딜레이 건 후에 녹색 출력
            Green.visibility = View.VISIBLE

        }, (randtime.toLong() * 1000)) // 밀리초단위로 나오기때문에 * 1000 해줌

        // 3. 출력과 동시에 시간체크 (timer 함수 만들기?)

        // 4. 사용자가 터치시 타이머 정지하고 결과를 ms단위로 보여줌

    }
}