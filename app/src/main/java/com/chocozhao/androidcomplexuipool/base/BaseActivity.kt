package com.chocozhao.androidcomplexuipool.base

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.blankj.utilcode.util.StringUtils
import com.chocozhao.androidcomplexuipool.R

/**
 * author: chocozhao
 * created on: 2020/9/8 11:00
 * description:
 */
open class BaseActivity : AppCompatActivity() {




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