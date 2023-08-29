package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.profile_image1, "이양파", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.profile_image2, "김당근", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.profile_image1, "이양파", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.profile_image2, "김당근", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.profile_image1, "이양파", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.profile_image2, "김당근", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.profile_image1, "이양파", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.profile_image2, "김당근", "010-2222-3333", false))
        dataList.add(MyItem(R.drawable.profile_image1, "이양파", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.profile_image2, "김당근", "010-2222-3333", false))

        binding.recyclerView.adapter = MyAdapter(dataList)

        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val decoration = AddressAdapterDecoration()
        recyclerView.addItemDecoration(decoration)
    }
}