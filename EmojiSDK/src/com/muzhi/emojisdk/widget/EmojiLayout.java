package com.muzhi.emojisdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.muzhi.emojisdk.R;
import com.muzhi.emojisdk.adapter.FaceCategroyAdapter;
import com.muzhi.emojisdk.utils.FileUtils;
import com.muzhi.emojisdk.utils.OnOperationListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 控件主界面
 *
 * @author Jazzy
 */
@SuppressLint("NewApi")
public class EmojiLayout extends RelativeLayout  {

    public interface OnToolBoxListener {
        void onShowFace();
    }

    public static final int LAYOUT_TYPE_HIDE = 0;
    public static final int LAYOUT_TYPE_FACE = 1;
    public static final int LAYOUT_TYPE_MORE = 2;


    private ViewPager mPagerFaceCagetory;
    private PagerSlidingTabStrip mFaceTabs;

    private int layoutType = LAYOUT_TYPE_HIDE;
    private FaceCategroyAdapter adapter;  //点击表情按钮时的适配器

    private List<String> mFaceData;

    private Context context;
    private OnOperationListener listener;
    private Typeface emojitf;

    public EmojiLayout(Context context) {
        super(context);
        init(context);
    }

    public EmojiLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EmojiLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        View root = View.inflate(context, R.layout.emojisdk_face_box, null);
        this.addView(root);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initData();
        this.initWidget();
    }

    private void initData() {
        if (!"smartisan".equals(Build.MANUFACTURER)) {
            try {
                emojitf = Typeface.createFromAsset(context.getAssets(), "fonts/emoji.ttf");
            } 
            catch (Exception e) {
            }
        }
    }

    private void initWidget() {

        mPagerFaceCagetory = (ViewPager) findViewById(R.id.toolbox_pagers_face);
        mFaceTabs = (PagerSlidingTabStrip) findViewById(R.id.toolbox_tabs);
        adapter = new FaceCategroyAdapter(((FragmentActivity) getContext()).getSupportFragmentManager(), LAYOUT_TYPE_FACE);
      
        
        List<String> faceCagegory = new ArrayList<String>();
        File faceList = FileUtils.getSaveFolder("emoji");
        if (faceList.isDirectory()) {
            File[] faceFolderArray = faceList.listFiles();
            for (File folder : faceFolderArray) {
                if (!folder.isHidden()) {
                    faceCagegory.add(folder.getAbsolutePath());
                }
            }
        }
        setFaceData(faceCagegory);
        
    }

 
    public void setFaceData(List<String> faceData) {
        mFaceData = faceData;
        adapter.refresh(faceData);
        mPagerFaceCagetory.setAdapter(adapter);
        mFaceTabs.setViewPager(mPagerFaceCagetory);
        
        if (layoutType == LAYOUT_TYPE_MORE) {
            mFaceTabs.setVisibility(GONE);
        } 
        else {
            //加1是表示第一个分类为默认的emoji表情分类，这个分类是固定不可更改的
            if (faceData.size() + 1 < 2) {
                mFaceTabs.setVisibility(GONE);
            } else {
                mFaceTabs.setVisibility(VISIBLE);
            }
        }
    }
    
    
    public OnOperationListener getOnOperationListener() {
        return listener;
    }

    public void setOnOperationListener(OnOperationListener onOperationListener) {
        this.listener = onOperationListener;
        adapter.setOnOperationListener(onOperationListener);
    }
    
  

}
