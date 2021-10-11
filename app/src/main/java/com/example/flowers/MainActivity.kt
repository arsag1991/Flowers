package com.example.flowers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flowers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private  val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5
    )
    private var index = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }
    private fun init() = with (binding){
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        rcView.adapter = adapter
        buttonAdd.setOnClickListener {
            if (index > 4) index = 0
            val plant = Plant (imageIdList[index], "Plant: ${index+1}")
            adapter.addPlant(plant)
            index++
        }

    }


}