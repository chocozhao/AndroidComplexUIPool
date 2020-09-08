package com.chocozhao.androidcomplexuipool

import android.app.Application
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.LogUtils.Config

/**
 * author: chocozhao
 * created on: 2020/9/2 15:13
 * description:
 */
class App : Application() {

    companion object {
        // 按照我们在Java中一样创建一个单例最简单的方式：
        private var mContext: Application? = null;
        fun getContext() = mContext!!;
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        //初始化日志的tag
        LogUtils.getConfig().globalTag = "chococzhao"
    }
}