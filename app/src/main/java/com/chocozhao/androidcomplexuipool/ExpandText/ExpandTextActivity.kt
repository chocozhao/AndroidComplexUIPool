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
import com.chocozhao.androidcomplexuipool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_expand_text.*
import kotlinx.android.synthetic.main.view_tool_bar.*

class ExpandTextActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expand_text)

        initData()
    }

    private fun initData() {

        setToolBar(toolbar, "ListSingleSelection")
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


}