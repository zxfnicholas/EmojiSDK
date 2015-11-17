package com.muzhi.emojisdk.example.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.muzhi.emojisdk.example.R;
import com.muzhi.emojisdk.utils.OnEmojiOperationListener;
import com.muzhi.emojisdk.utils.SoftKeyboardStateHelper;
import com.muzhi.emojisdk.utils.UrlUtils;
import com.muzhi.emojisdk.widget.EmojiLayout;



/**
 * 控件主界面
 *
 * @author Jazzy
 */
public class ChatKeyboard extends RelativeLayout implements  SoftKeyboardStateHelper.SoftKeyboardStateListener {

    /**
     * 状态
     */
    public static final int LAYOUT_TYPE_HIDE = 0;
    public static final int LAYOUT_TYPE_FACE = 1;
    public static final int LAYOUT_TYPE_MORE = 2;

    /**
     * 外层基本控件
     */
    private EditText mEtMsg;
    private CheckBox mBtnFace;
    private CheckBox mBtnMore;
    private Button mBtnSend;

    
    /**
     * 更多控件中铵钮
     */
    private LinearLayout layout_image;
    private LinearLayout layout_photo;
    
    /**
     * 显示控件
     */
    private EmojiLayout mEmojiLayout;		// 表情Frame
    private RelativeLayout moreLayout_box;	//更多自定义Frame
    
    


    private int layoutType = LAYOUT_TYPE_HIDE;
    
    private Context context;
    private OnEmojiOperationListener listener;
    private SoftKeyboardStateHelper mKeyboardHelper;
    private Typeface emojitf;

    
    
    public ChatKeyboard(Context context) {
        super(context);
        init(context);
    }

    public ChatKeyboard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ChatKeyboard(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        View root = View.inflate(context, R.layout.chat_tool_box, null);
        this.addView(root);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initData();
        this.initWidget();
    }

    private void initData() {
        mKeyboardHelper = new SoftKeyboardStateHelper(((Activity) getContext()).getWindow().getDecorView());
        mKeyboardHelper.addSoftKeyboardStateListener(this);
        emojitf=UrlUtils.getEmojiTypeface(getContext());
    }

    private void initWidget() {
        mEtMsg = (EditText) findViewById(R.id.toolbox_et_message);
        if (emojitf != null) {
            mEtMsg.setTypeface(emojitf);
        }
        mBtnSend = (Button) findViewById(R.id.toolbox_btn_send);
        mBtnFace = (CheckBox) findViewById(R.id.toolbox_btn_face);
        mBtnMore = (CheckBox) findViewById(R.id.toolbox_btn_more);

        
        mEmojiLayout=(EmojiLayout)findViewById(R.id.emojiLayout_box);
        moreLayout_box=(RelativeLayout)findViewById(R.id.moreLayout_box);
        
        layout_image = (LinearLayout) findViewById(R.id.chat_menu_images);
        layout_photo = (LinearLayout) findViewById(R.id.chat_menu_photo);
        
        layout_image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (listener != null) {
		            listener.selectedFunction(0);
		        }
			}
		});
        layout_photo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (listener != null) {
		            listener.selectedFunction(1);
		        }
			}
		});
        
        mBtnSend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    String content = mEtMsg.getText().toString();
                    listener.send(content);
                    mEtMsg.setText(null);
                }
            }
        });
        // 点击表情按钮
        mBtnFace.setOnClickListener(getFunctionBtnListener(LAYOUT_TYPE_FACE));
        // 点击表情按钮旁边的加号
        mBtnMore.setOnClickListener(getFunctionBtnListener(LAYOUT_TYPE_MORE));
        // 点击消息输入框
        mEtMsg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLayout();
            }
        });
       
    }

    /*************************
     * 内部方法 start
     ************************/

    private OnClickListener getFunctionBtnListener(final int which) {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	layoutType = which;
            	
            	mBtnFace.setChecked(layoutType == LAYOUT_TYPE_FACE);
            	mBtnMore.setChecked(layoutType == LAYOUT_TYPE_MORE);
            	
            	switch(which){
            		case LAYOUT_TYPE_HIDE:
            			hideLayout();
            			showKeyboard(context);
            			break;
            		case LAYOUT_TYPE_FACE:
            			mEmojiLayout.setVisibility(View.VISIBLE);
                		moreLayout_box.setVisibility(View.GONE);
                		hideKeyboard(context);
            			break;
            		case LAYOUT_TYPE_MORE:
            			mEmojiLayout.setVisibility(View.GONE);
                		moreLayout_box.setVisibility(View.VISIBLE);
                		hideKeyboard(context);
            			break;
            		
            	}
            	
            }
        };
    }

    

    @Override
    public void onSoftKeyboardOpened(int keyboardHeightInPx) {
        hideLayout();
    }

    @Override
    public void onSoftKeyboardClosed() {
    }



    public EditText getEditTextBox() {
        return mEtMsg;
    }


    public boolean isShow() {
    	if(mEmojiLayout.getVisibility() == VISIBLE || moreLayout_box.getVisibility()==VISIBLE){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    //隐藏所有
    public void hideLayout() {
    	mEmojiLayout.setVisibility(View.GONE);
    	moreLayout_box.setVisibility(View.GONE);
    	
    	mBtnFace.setChecked(false);
    	mBtnMore.setChecked(false);
    }



    public OnEmojiOperationListener getOnOperationListener() {
        return listener;
    }

    public void setOnOperationListener(OnEmojiOperationListener onOperationListener) {
        this.listener = onOperationListener;
        mEmojiLayout.setOnOperationListener(onOperationListener);
    }

    
    /**
     * 隐藏软键盘
     */
    public void hideKeyboard(Context context) {
        Activity activity = (Activity) context;
        if (activity != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm.isActive() && activity.getCurrentFocus() != null) {
                imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    /**
     * 显示软键盘
     */
    public static void showKeyboard(Context context) {
        Activity activity = (Activity) context;
        if (activity != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInputFromInputMethod(activity.getCurrentFocus().getWindowToken(), 0);
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
