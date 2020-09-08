package com.chocozhao.androidcomplexuipool.ListSingleSelection

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chocozhao.androidcomplexuipool.R
import kotlinx.android.synthetic.main.item_list_single_selection.view.*


/**
 * author: chocozhao
 * created on: 2020/9/2 16:39
 * description:
 */
class ListSingleSelectionAdapter : RecyclerView.Adapter<ListSingleSelectionAdapter.ViewHolder> {


    private var data: MutableList<ListSingleSelectionBean>
    private var mTag = 0 //默认选中推荐


    constructor(data: MutableList<ListSingleSelectionBean>) {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_single_selection, parent, false))
    }


    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.mItemTag.text = data[position].itemName
        holder.itemView.mItemTag.setOnClickListener {
            //防止重复点击
            if (mTag != position) {
                mTag = position
                mLabelListener(position,data[position].itemName)
                notifyDataSetChanged()
            }
        }

        if (mTag == position) {
            holder.itemView.mItemTag.setBackgroundColor(Color.YELLOW)
        } else {
            holder.itemView.mItemTag.setBackgroundColor(Color.WHITE)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

    lateinit var mLabelListener:(Int,String) -> Unit

    fun setOnLabelListener(listener:(Int,String) -> Unit) {
        mLabelListener = listener
    }
}