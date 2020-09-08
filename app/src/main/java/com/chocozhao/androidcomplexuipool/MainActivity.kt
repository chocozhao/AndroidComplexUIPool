package com.chocozhao.androidcomplexuipool

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chocozhao.androidcomplexuipool.ExpandText.ExpandTextActivity
import com.chocozhao.androidcomplexuipool.ListSingleSelection.ListSingleSelectionActivity
import com.chocozhao.androidcomplexuipool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_tool_bar.*

class MainActivity : BaseActivity() {
    private val mainItemData: ArrayList<MainItemBean>
        get() = arrayListOf(
                MainItemBean(getString(R.string.item_expand_text)),
                MainItemBean(getString(R.string.item_list_single_selection)),
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolBar(toolbar,"AndroidComplexUIPool")

        initAdapter()
    }

    private fun initAdapter() {
        mRecyclerView.layoutManager = LinearLayoutManager(this)
                .also { linearLayoutManager -> linearLayoutManager.orientation = LinearLayoutManager.VERTICAL }
        mRecyclerView.addItemDecoration(DividerItemDecoration(App.getContext(),DividerItemDecoration.HORIZONTAL))
        val mainAdapter = MainAdapter(mainItemData)
        mRecyclerView.adapter = mainAdapter
        mainAdapter.setOnItemClickListener(OnItemClickListener { adapter, view, position ->
            when (mainAdapter.getItem(position).itemName) {
                "ExpandTextView" -> {
                    startActivity(Intent(this, ExpandTextActivity::class.java))
                }
                "ListSingleSelection" -> {
                    startActivity(Intent(this,ListSingleSelectionActivity::class.java))
                }

            }
        })
    }


}