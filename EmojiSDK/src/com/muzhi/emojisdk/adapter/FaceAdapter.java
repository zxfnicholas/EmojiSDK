package com.muzhi.emojisdk.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;
import com.muzhi.emojisdk.R;
import com.muzhi.emojisdk.model.Faceicon;
import com.muzhi.mdroid.adapter.CommonListAdapter;
import com.muzhi.mdroid.tools.ViewHolder;


/**
 * 表情区域GridView的适配器
 *
 * @author Jazzy
 */
public class FaceAdapter extends CommonListAdapter<Faceicon> {
	
	private BitmapUtils bitmapUtils ;
	
	public FaceAdapter(Context mContext) {
		super(mContext);
		this.mLayoutId=R.layout.emojisdk_chat_item_face;
		bitmapUtils = new BitmapUtils(mContext);
	}


	@Override
	public void getCommonView(final ViewHolder helper, Faceicon item) {
		// TODO Auto-generated method stub
		
		ImageView view = helper.getView(R.id.itemImage);
		bitmapUtils.display(view, item.getPath());
	}
	
}