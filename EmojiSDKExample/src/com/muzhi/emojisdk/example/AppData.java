package com.muzhi.emojisdk.example;


import com.muzhi.emojisdk.EmojiSDK;

import android.app.Application;
import android.content.Context;

public final class AppData extends Application{
	
	public static Context applicationContext;
	private static AppData instance;
	
	
	
    @Override
    public void onCreate() {
        super.onCreate();
                
        instance = this;
        applicationContext = this;
        
        EmojiSDK.init(this);
        
    }
    
    public static AppData getInstance() {
        return instance;
    }
    
	
}

