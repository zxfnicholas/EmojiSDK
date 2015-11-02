package com.muzhi.emojisdk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;


/**
 * 兼容v4包的Fragment
 *
 * @author 
 */
public abstract class BaseFragment extends Fragment implements OnClickListener {
        


    protected View rootView;



    protected abstract View inflaterView(LayoutInflater inflater,ViewGroup container, Bundle bundle);

   
    protected void initView(View parentView) {}
    protected void initData() {}
    //当通过changeFragment()显示时会被调用(类似于onResume)
    public void onChange() {}
    protected void initClick(View v) {}

    
    
    @Override
    public void onClick(View v) {
    	initClick(v);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    	rootView = inflaterView(inflater, container, savedInstanceState);
        initData();
        initView(rootView);
        return rootView;
    }

    protected <T extends View> T bindView(int id) {
        return (T) rootView.findViewById(id);
    }

    protected <T extends View> T bindView(int id, boolean click) {
        T view = (T) rootView.findViewById(id);
        if (click) {
            view.setOnClickListener(this);
        }
        return view;
    }
}