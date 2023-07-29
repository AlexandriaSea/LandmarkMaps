package com.example.wenjiezhou_shengwang_comp304sec002_lab05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LandmarkActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LandmarkAdapter
    private var landmarks: List<Landmark> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmark)

        val selectedType = intent.getStringExtra("landmarkType") ?: ""

        recyclerView = findViewById(R.id.recyclerViewLandmark)
        landmarks = getLandmarksByType(selectedType)
        adapter = LandmarkAdapter(this, landmarks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun getLandmarksByType(type: String): List<Landmark> {
        when(type)
        {
            "Old Buildings" -> return listOf(
                Landmark("Gibraltar Point Lighthouse", "443 Lakeshore Ave, Toronto", 43.6137, -79.3853),
                Landmark("The Grange", "317 Dundas St W, Toronto",43.6531, -79.3924))

            "Museums" -> return listOf(
                Landmark("Royal Ontario Museum", "100 Queens Park, Toronto", 43.6677, -79.3948),
                Landmark("Ontario Science Centre", "770 Don Mills Rd., North York",43.7169, -79.3389))

            "Stadiums" -> return listOf(
                Landmark("Scotiabank Arena", "40 Bay St., Toronto", 43.6435, -79.3791),
                Landmark("BMO Field", "170 Princes' Blvd, Toronto",43.6332, -79.4186))

            "Attractions" -> return listOf(
                Landmark("CN Tower", "290 Bremner Blvd, Toronto", 43.6426, -79.3871),
                Landmark("Toronto Zoo", "2000 Meadowvale Rd, Toronto",43.8207, -79.1815))

            else -> return listOf(
                Landmark("Centennial College", "941 Progress Ave, Scarborough", 43.7852, -79.2282))
        }
    }
}