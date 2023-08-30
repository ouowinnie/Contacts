package com.example.contacts

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.ItemRvBinding

class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }
    var itemClick : ItemClick? = null

    inner class Holder(val binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root) {
        val profile = binding.profile
        val name = binding.name
        val number = binding.number
        val favorite = binding.favorite
        init {
            profile.clipToOutline = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.profile.setImageResource(mItems[position].profile)
        holder.name.text = mItems[position].name
        holder.number.text = mItems[position].number
        val favoriteIconDrawable = if (mItems[position].favorite) {
            ContextCompat.getDrawable(holder.itemView.context, R.drawable.star_filled)
        } else {
            ContextCompat.getDrawable(holder.itemView.context, R.drawable.star_empty)
        }
        holder.favorite.setImageDrawable(favoriteIconDrawable)
    }
}

class AddressAdapterDecoration : RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val paint = Paint()
        paint.color = Color.GRAY

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val layoutParams = child.layoutParams as RecyclerView.LayoutParams
            val top = (child.bottom + layoutParams.bottomMargin + 40).toFloat()
            val bottom = top + 1f

            val left = parent.paddingStart.toFloat()
            val right = (parent.width - parent.paddingEnd).toFloat()

            c.drawRect(left, top, right, bottom, paint)
        }
    }
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val offset = 40
        outRect.top = offset
        outRect.bottom = offset
    }
}