package com.chocozhao.androidcomplexuipool.ExpandText

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.StringUtils
import com.chocozhao.androidcomplexuipool.R
import kotlinx.android.synthetic.main.activity_expand_text.*
import kotlinx.android.synthetic.main.view_tool_bar.*

class ExpandTextActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expand_text)

        initData()
    }

    private fun initData() {

        setToolBar(toolbar, "ExpandTextView")
        mExpandText.setText(
                "androidComplexUIPool is warehouse!!!" +
                        "androidComplexUIPool is warehouse!!!" +
                        "androidComplexUIPool is warehouse!!!" +
                        "androidComplexUIPool is warehouse!!!" +
                        "androidComplexUIPool is warehouse!!!" +
                        "androidComplexUIPool is warehouse!!!" +
                        "androidComplexUIPool is warehouse!!!" +
                        "androidComplexUIPool is warehouse!!!" +
                        "androidComplexUIPool is warehouse!!!" +
                        "androidComplexUIPool is warehouse!!!" +
                        "androidComplexUIPool is warehouse!!!" +
                        "androidComplexUIPool is warehouse!!!" +
                        "androidComplexUIPool is warehouse!!!")
    }

    /**
     * 如果使用的是项目中的共用Toolbar
     *
     * @param toolbar
     * @param title
     */
    fun setToolBar(toolbar: Toolbar?, title: String?) {
        //假如使用的是标准的toolbar
        if (toolbar != null && toolbar.id === R.id.toolbar) {
            if (!StringUtils.isEmpty(title)) {
                try {
                    val tvTitle = toolbar.findViewById(R.id.txt_toolbar_title) as TextView
                    tvTitle.visibility = View.VISIBLE
                    tvTitle.text = title
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        toolbar?.setNavigationOnClickListener { onBackPressed() }
    }
}