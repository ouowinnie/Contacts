package com.example.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.ActivityMainBinding
import com.example.contacts.databinding.FragmentTitleBinding

class FragmentTitle : Fragment() {

    private lateinit var binding: FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTitleBinding.inflate(inflater, container, false)
        val root = binding.root

        val titleItems = mutableListOf<String>()
        titleItems.add("👉 LGU+, 업계 최초 지상파·종편VOD 통합 요금제 '환승구독' 출시")
        titleItems.add("👉 LG유플러스 ‘아이들나라’, 어린이집·유치원에 콘텐츠 제공")
        titleItems.add("👉 BTS '뷔'도 선택한 음악 콘서트, LG유플러스 '타이니데스크'")
        titleItems.add("👉 LGU+, 전국 8개 대학과 연합 '유쓰 페스티벌' 성료")
        titleItems.add("👉 LG유플러스 IPTV, 'ICT 어워드 코리아 2023' 장관상 수상")
        titleItems.add("👉 LGU+, 업계 최초 지상파·종편VOD 통합 요금제 '환승구독' 출시")
        titleItems.add("👉 LG유플러스 ‘아이들나라’, 어린이집·유치원에 콘텐츠 제공")
        titleItems.add("👉 BTS '뷔'도 선택한 음악 콘서트, LG유플러스 '타이니데스크'")
        titleItems.add("👉 LGU+, 전국 8개 대학과 연합 '유쓰 페스티벌' 성료")
        titleItems.add("👉 LG유플러스 IPTV, 'ICT 어워드 코리아 2023' 장관상 수상")
        titleItems.add("👉 LGU+, 업계 최초 지상파·종편VOD 통합 요금제 '환승구독' 출시")
        titleItems.add("👉 LG유플러스 ‘아이들나라’, 어린이집·유치원에 콘텐츠 제공")
        titleItems.add("👉 BTS '뷔'도 선택한 음악 콘서트, LG유플러스 '타이니데스크'")
        titleItems.add("👉 LGU+, 전국 8개 대학과 연합 '유쓰 페스티벌' 성료")
        titleItems.add("👉 LG유플러스 IPTV, 'ICT 어워드 코리아 2023' 장관상 수상")

        val articleTitle = binding.root.findViewById<RecyclerView>(R.id.articleTitle)

        val atAdapter = ArtiAdapter(titleItems)
        articleTitle.adapter = atAdapter
        articleTitle.layoutManager = LinearLayoutManager(context)

        val decoration = ArtiAdapter.AddressAdapterDecoration()
        binding.articleTitle.addItemDecoration(decoration)

        return root
    }
}