package com.example.contacts

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

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

        adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val decoration = MyAdapter.AddressAdapterDecoration()
        binding.recyclerView.addItemDecoration(decoration)

        adapter.numberClick = object : MyAdapter.NumberClick {
            override fun onNumberClick(view: View, position: Int) {
                val item = dataList[position]
                val number: String = dataList[position].number
                val intnet = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                Log.d("MyAdapter", "Favorite clicked at position: $item")
                startActivity(intnet)
            }
        }
        adapter.favoriteClick = object : MyAdapter.FavoriteClick {
            override fun onFavoriteClick(view: View, position: Int) {
                val item = dataList[position]
                item.toggleFavorite()
                Log.d("MyAdapter", "Favorite clicked at position: $item")
                adapter.notifyItemChanged(position)
            }
        }
    }
}