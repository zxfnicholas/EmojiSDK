package com.muzhi.emojisdk.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;

import com.muzhi.emojisdk.R;
import com.muzhi.emojisdk.model.EmojiInfo;
import com.muzhi.mdroid.adapter.CommonListAdapter;
import com.muzhi.mdroid.tools.ViewHolder;


/**
 * emoji表情界面gridview适配器
 *
 * @author Jazzy
 */

@SuppressLint("NewApi")
public class EmojiAdapter extends CommonListAdapter<EmojiInfo> {
	
    private Typeface emojitf;

	
	public EmojiAdapter(Context mContext) {
		super(mContext);
		this.mLayoutId=R.layout.emojisdk_chat_item_emoji;
		
		if (!"smartisan".equals(Build.MANUFACTURER)) {
            try {
            	
                emojitf = Typeface.createFromAsset(mContext.getResources().getAssets(), "fonts/emoji" +".ttf");
            } catch (Exception e) {
            }
        }
	}


	@Override
	public void getCommonView(final ViewHolder helper, EmojiInfo item) {
		// TODO Auto-generated method stub
		
		TextView itemTvEmoji = helper.getView(R.id.itemEmoji);
        if (emojitf != null) {
            itemTvEmoji.setTypeface(emojitf);
        }
        String txt=item.getEmojiValue();
        itemTvEmoji.setText(txt);
		
	}
	
}
