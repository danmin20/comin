package com.danmin.comin.Fragment.MarketInfo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Toast
import com.danmin.comin.R
import com.danmin.comin.Utils.FirebaseUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_marketinfo.*

class MarketinfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marketinfo)

        lecture_text.text = intent.getStringExtra("title")

        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.get(intent.getStringExtra("title")) == true) {
                    header_zzim.text = "찜 목록에 추가되었습니다"
                    header_zzim.setTextColor(Color.GRAY)
                }
            }
            .addOnFailureListener { }

        zzim.setOnClickListener {
            if (header_zzim.text.equals("찜 목록에 추가되었습니다")) {
                //when it's already taken
                header_zzim.text = "찜 목록에 추가하기"
                header_zzim.setTextColor(Color.RED)

                FirebaseUtils.db
                    .collection("zzim")
                    .document(FirebaseUtils.getUid())
                    .update(intent.getStringExtra("title"), "")
                    .addOnSuccessListener {
                        Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "fail", Toast.LENGTH_LONG).show()
                    }
            } else {
                //when it isn't taken
                header_zzim.text = "찜 목록에 추가되었습니다"
                header_zzim.setTextColor(Color.GRAY)

                FirebaseUtils.db
                    .collection("zzim")
                    .document(FirebaseUtils.getUid())
                    .update(intent.getStringExtra("title"), true)
                    .addOnSuccessListener {
                        Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "fail", Toast.LENGTH_LONG).show()
                    }
            }
        }

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
