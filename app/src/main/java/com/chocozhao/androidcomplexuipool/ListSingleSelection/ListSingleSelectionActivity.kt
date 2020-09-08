package com.chocozhao.androidcomplexuipool.ListSingleSelection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.chocozhao.androidcomplexuipool.R
import com.chocozhao.androidcomplexuipool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_list_single_selection.*
import kotlinx.android.synthetic.main.view_tool_bar.*

class ListSingleSelectionActivity : BaseActivity() {

    private val arrayList: ArrayList<ListSingleSelectionBean>
        get() = arrayListOf(
                ListSingleSelectionBean("快乐"),
                ListSingleSelectionBean("真香"),
                ListSingleSelectionBean("冲冲冲"),
                ListSingleSelectionBean("詹姆斯"),
                ListSingleSelectionBean("保罗"),
                ListSingleSelectionBean("保罗乔治"),
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_single_selection)
        setToolBar(toolbar,"ListSingleSelection")
        initAdapter()
    }

    private fun initAdapter() {
        mRvListSingleSelection.layoutManager = LinearLayoutManager(this)
                .also { linearLayoutManager -> linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL }
        val mAdapter = ListSingleSelectionAdapter(arrayList)
        mRvListSingleSelection.adapter = mAdapter
        mAdapter.setOnLabelListener { position, tag ->
            when (position){
                position -> ToastUtils.showShort(tag)
            }

        }

    }
}