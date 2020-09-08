package com.chocozhao.androidcomplexuipool.ExpandText;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chocozhao.androidcomplexuipool.R;

/**
 * author: chocozhao
 * created on: 2020/9/2 10:51
 * description:   展开或者收缩
 */
public class ExpandTextView extends LinearLayout {
    /**
     * 设置的行数
     */
    public static final int DEFAULT_MAX_LINES = 3;
    /**
     * 文本内容
     */
    private TextView mContentText;
    /**
     * 展开或收缩显示
     */
    private TextView mTextPlus;
    private RelativeLayout mRlTextPlus;
    /**
     * 展开或收缩的icon显示
     */
    private ImageView mIvTextPlus;

    /**
     * 展开状态的监听
     */
    private ExpandStatusListener expandStatusListener;
    /**
     * 是否展开
     */
    private boolean isExpand;
    /**
     * 展示的行数
     */
    private int showLines;

    public ExpandTextView(Context context) {
        super(context);
        initView();
    }

    public ExpandTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
        initView();
    }

    public ExpandTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
        initView();
    }

    /**
     * 初始化属性
     * @param attrs
     */
    private void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ExpandTextView, 0, 0);
        try {
            showLines = typedArray.getInt(R.styleable.ExpandTextView_showLines, DEFAULT_MAX_LINES);
        } finally {
            typedArray.recycle();
        }
    }
    /**
     * 初始化UI
     */
    private void initView() {
        //设置布局垂直
        setOrientation(LinearLayout.VERTICAL);

        LayoutInflater.from(getContext()).inflate(R.layout.layout_expand_text, this);
        mContentText = findViewById(R.id.tv_expand_content);
        mContentText.setEllipsize(TextUtils.TruncateAt.END);
        mTextPlus = findViewById(R.id.tv_expand_plus);
        mRlTextPlus = findViewById(R.id.rl_plus);
        mIvTextPlus = findViewById(R.id.iv_expand_plus);

        //选择展开或者收缩的点击
        mRlTextPlus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String textStr = mTextPlus.getText().toString().trim();
                if ("展开".equals(textStr)) {//点击展开
                    mContentText.setMaxLines(Integer.MAX_VALUE);   //重置最大的行数
                    mTextPlus.setText("收缩");
                    mIvTextPlus.setBackground(getResources().getDrawable(R.mipmap.icon_shrink));
                    ExpandTextView.this.setExpand(true);
                } else {//点击收缩
                    mContentText.setMaxLines(showLines);  //恢复需要显示的行数
                    mTextPlus.setText("展开");
                    mIvTextPlus.setBackground(getResources().getDrawable(R.mipmap.icon_unfold));
                    ExpandTextView.this.setExpand(false);
                }
                //通知外部状态已变更
                if (expandStatusListener != null) {
                    expandStatusListener.statusChange(ExpandTextView.this.isExpand());
                }
            }
        });

    }


    /**
     * 需要显示的文本
     * @param content
     */
    public void setText(final CharSequence content) {
        //重置最大行数
        mContentText.setMaxLines(Integer.MAX_VALUE);
        //需要内容显示
        mContentText.setText(content);
        mContentText.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

            @Override
            public boolean onPreDraw() {
                // 避免重复监听
                mContentText.getViewTreeObserver().removeOnPreDrawListener(this);
                //获取文本显示的行数
                int linCount = mContentText.getLineCount();
                //判断大于设定的行数
                if (linCount > showLines) {
                    if (isExpand) {
                        mContentText.setMaxLines(Integer.MAX_VALUE);  //重置最大的行数
                        mTextPlus.setText("收缩");
                        mIvTextPlus.setBackground(getResources().getDrawable(R.mipmap.icon_shrink));
                    } else {
                        mContentText.setMaxLines(showLines);  //恢复需要显示的行数
                        mTextPlus.setText("展开");
                        mIvTextPlus.setBackground(getResources().getDrawable(R.mipmap.icon_unfold));
                    }
                    mRlTextPlus.setVisibility(View.VISIBLE);
                } else {
                    mRlTextPlus.setVisibility(View.GONE);
                }
                return true;
            }
        });
    }

    public void setExpand(boolean isExpand) {
        this.isExpand = isExpand;
    }

    public boolean isExpand() {
        return this.isExpand;
    }

    public void setExpandStatusListener(ExpandStatusListener listener) {
        this.expandStatusListener = listener;
    }

    public interface ExpandStatusListener {

        void statusChange(boolean isExpand);
    }

}
