package com.example.wenjiezhou_shengwang_comp304sec002_lab05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter
    private val types: List<Type> = getLandmarkTypes()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewMain)
        adapter = MainAdapter(this, types)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    // Replace this with your data retrieval mechanism
    private fun getLandmarkTypes(): List<Type> {
        return listOf(
            Type("Old Buildings"),
            Type("Museums"),
            Type("Stadiums"),
            Type("Attractions")
        )
    }
}