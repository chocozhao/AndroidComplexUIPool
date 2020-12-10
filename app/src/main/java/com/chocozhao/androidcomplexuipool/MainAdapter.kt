package com.chocozhao.androidcomplexuipool

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * author: chocozhao
 * created on: 2020/9/2 11:32
 * description:
 */
class MainAdapter(data: MutableList<MainItemBean>) : BaseQuickAdapter<MainItemBean, BaseViewHolder>(R.layout.item_main,data) {

    override fun convert(holder: BaseViewHolder, item: MainItemBean) {
        holder.setText(R.id.mMainItem, item.itemName)
    }
}