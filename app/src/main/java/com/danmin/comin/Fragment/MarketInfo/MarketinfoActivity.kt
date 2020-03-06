package com.danmin.comin.Fragment.MarketInfo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import com.danmin.comin.R
import kotlinx.android.synthetic.main.activity_marketinfo.*

class MarketinfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marketinfo)

        figure_1.setTextColor(Color.BLACK)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_area, ContentFragment())
            .commit()

        figure_1.setOnClickListener {
            figure_1.setTextColor(Color.BLACK)
            figure_2.setTextColor(Color.parseColor("#808080"))
            figure_3.setTextColor(Color.parseColor("#808080"))

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_area, ContentFragment())
                .commit()
        }
        figure_2.setOnClickListener {
            figure_1.setTextColor(Color.parseColor("#808080"))
            figure_2.setTextColor(Color.BLACK)
            figure_3.setTextColor(Color.parseColor("#808080"))

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_area, InfoFragment())
                .commit()
        }
        figure_3.setOnClickListener {
            figure_1.setTextColor(Color.parseColor("#808080"))
            figure_2.setTextColor(Color.parseColor("#808080"))
            figure_3.setTextColor(Color.BLACK)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_area, ReviewFragment())
                .commit()
        }
    }
}
