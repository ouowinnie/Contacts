package com.example.contacts

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val CALL_REQUEST_CODE = 1;
    var telNum: String = ""
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

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].name
                val number: String = dataList[position].number
                val intnet = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                startActivity(intnet)
            }
        }
    }
}