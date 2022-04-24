package com.cwise.teacherappkotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cwise.teacherappkotlin.ApiPost
import com.cwise.teacherappkotlin.R
import com.cwise.teacherappkotlin.models.ChildRecRes
import com.cwise.teacherappkotlin.models.Datum
import com.cwise.teacherappkotlin.models.Loading
import com.cwise.teacherappkotlin.models.ShowRecAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PresentRecActivity : AppCompatActivity() {
    private lateinit var presentRV:RecyclerView
    private lateinit var childRecRes: ChildRecRes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_present_rec)
        presentRV = findViewById(R.id.rv_present)
        getPresentRec("present")
    }

    private fun getPresentRec(status: String) {
        Loading.show(this)
        val retrofit=Retrofit.Builder().baseUrl("https://sts.mobifinplus.com/api/").addConverterFactory(
            GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiPost::class.java)
        childRecRes= ChildRecRes(null.toString(),status)
        service.getPresentRec(childRecRes).enqueue(object :Callback<ChildRecRes>{
            override fun onResponse(call: Call<ChildRecRes>, response: Response<ChildRecRes>) {
                if (response.isSuccessful) run {
                    var list: List<Datum> = response.body()?.data!!
                    if (list != null) {
                        presentRV.apply {
                            Loading.dismiss()
                            layoutManager = LinearLayoutManager(this@PresentRecActivity)
                            adapter = ShowRecAdapter(list!! as MutableList<Datum>)
                        }
                    }
                } else {
                    Loading.dismiss()
                    Log.wtf("response","fail")
                }
            }

            override fun onFailure(call: Call<ChildRecRes>, t: Throwable) {
                Loading.dismiss()
                Toast.makeText(applicationContext,t.message,Toast.LENGTH_SHORT).show()
            }

        })
//        val retrofit = Retro
    }
}