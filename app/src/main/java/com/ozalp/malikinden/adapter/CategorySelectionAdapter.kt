package com.ozalp.malikinden.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ozalp.malikinden.R
import com.ozalp.malikinden.databinding.CategorySelectionItemBinding
import com.ozalp.malikinden.model.Product
import com.ozalp.malikinden.util.CategoryItemClickListener
import com.ozalp.malikinden.util.ProductItemOnclickListener
import java.util.ArrayList

class CategorySelectionAdapter(val listener: ProductItemOnclickListener): RecyclerView.Adapter<CategorySelectionAdapter.CategorySelectionHolder>() {

    private val categorySelectionList = ArrayList<Product>()

    public fun setCategorySelectionList(arrayList: ArrayList<Product>) {
        categorySelectionList.clear()
        categorySelectionList.addAll(arrayList)
        notifyDataSetChanged()
    }

    class CategorySelectionHolder(val binding: CategorySelectionItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorySelectionHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CategorySelectionItemBinding>(inflater, R.layout.category_selection_item, parent, false)

        return CategorySelectionHolder(binding)
    }

    override fun getItemCount(): Int {
        return categorySelectionList.size
    }

    override fun onBindViewHolder(holder: CategorySelectionHolder, position: Int) {

        holder.binding.product = categorySelectionList[position]
        holder.binding.listener = listener

    }
}