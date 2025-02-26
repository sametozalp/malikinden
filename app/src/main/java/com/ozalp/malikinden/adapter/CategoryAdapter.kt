package com.ozalp.malikinden.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ozalp.malikinden.R
import com.ozalp.malikinden.databinding.CategoryItemBinding
import com.ozalp.malikinden.util.CategoryItemClickListener

class CategoryAdapter(private val listener: CategoryItemClickListener): RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    val categoryList: ArrayList<String> = ArrayList<String>()

    fun setCategoryList(newList: ArrayList<String>) {
        categoryList.clear()
        categoryList.addAll(newList)
        notifyDataSetChanged()
    }

    class CategoryHolder(val binding: CategoryItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CategoryItemBinding>(inflater, R.layout.category_item, parent, false)
        return CategoryHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.binding.category = categoryList[position]
        holder.binding.listener = listener
    }
}