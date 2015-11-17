package com.muzhi.emojisdk.example.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.lidroid.xutils.BitmapUtils;
import com.muzhi.emojisdk.example.ChatActivity.OnChatItemClickListener;
import com.muzhi.emojisdk.example.model.Message;
import com.muzhi.emojisdk.utils.UrlUtils;
import com.muzhi.emojisdk.example.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jazzy
 */
public class ChatAdapter extends BaseAdapter {

    private final Context cxt;
    private List<Message> datas = null;
    private OnChatItemClickListener listener;
    private Typeface emojitf;

    private BitmapUtils mBitmapUtils;
    
    
    public ChatAdapter(Context cxt, List<Message> datas, OnChatItemClickListener listener) {
        this.cxt = cxt;
        if (datas == null) {
            datas = new ArrayList<Message>(0);
        }
        this.datas = datas;
        this.listener = listener;
       
        emojitf=UrlUtils.getEmojiTypeface(cxt);
        
        mBitmapUtils=new BitmapUtils(cxt);
        
    }

    public void refresh(List<Message> datas) {
        if (datas == null) {
            datas = new ArrayList<Message>(0);
        }
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getIsSend() ? 1 : 0;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(final int position, View v, ViewGroup parent) {
        final ViewHolder holder;
        final Message data = datas.get(position);
        if (v == null) {
            holder = new ViewHolder();
            if (data.getIsSend()) {
                v = View.inflate(cxt, R.layout.chat_item_list_right, null);
            } else {
                v = View.inflate(cxt, R.layout.chat_item_list_left, null);
            }
            holder.layout_content = (RelativeLayout) v.findViewById(R.id.chat_item_layout_content);
            holder.img_avatar = (ImageView) v.findViewById(R.id.chat_item_avatar);
            holder.img_chatimage = (ImageView) v.findViewById(R.id.chat_item_content_image);
            holder.img_sendfail = (ImageView) v.findViewById(R.id.chat_item_fail);
            holder.progress = (ProgressBar) v.findViewById(R.id.chat_item_progress);
            holder.tv_chatcontent = (TextView) v.findViewById(R.id.chat_item_content_text);
            holder.tv_date = (TextView) v.findViewById(R.id.chat_item_date);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        holder.tv_date.setText("刚刚");
        holder.tv_date.setVisibility(View.VISIBLE);

        if (emojitf != null) {
            holder.tv_chatcontent.setTypeface(emojitf);
        }

        //如果是文本类型，则隐藏图片，如果是图片则隐藏文本
        if (data.getType() == Message.MSG_TYPE_TEXT) {
            holder.img_chatimage.setVisibility(View.GONE);
            holder.tv_chatcontent.setVisibility(View.VISIBLE);
            if (data.getContent().contains("href")) {
                holder.tv_chatcontent = UrlUtils.handleHtmlText(holder.tv_chatcontent, data.getContent());
            } else {
                holder.tv_chatcontent = UrlUtils.handleText(holder.tv_chatcontent, data.getContent());
            }
        } else {
            holder.tv_chatcontent.setVisibility(View.GONE);
            holder.img_chatimage.setVisibility(View.VISIBLE);
            mBitmapUtils.display(holder.img_chatimage, data.getContent());
        }

        //如果是表情或图片，则不显示气泡，如果是图片则显示气泡
        if (data.getType() != Message.MSG_TYPE_TEXT) {
            holder.layout_content.setBackgroundResource(android.R.color.transparent);
        } else {
            if (data.getIsSend()) {
                holder.layout_content.setBackgroundResource(R.drawable.chat_to_bg_selector);
            } else {
                holder.layout_content.setBackgroundResource(R.drawable.chat_from_bg_selector);
            }
        }

        //显示头像
        if (data.getIsSend()) {
        	mBitmapUtils.display(holder.img_avatar, "http://tp4.sinaimg.cn/1680783231/180/40064436090/1");
        } else {
        	mBitmapUtils.display(holder.img_avatar, "http://tp2.sinaimg.cn/1195242865/180/5707004896/0");
        }
        
        if (listener != null) {
            holder.tv_chatcontent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onTextClick(position);
                }
            });
            holder.img_chatimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (data.getType()) {
                        case Message.MSG_TYPE_PHOTO:
                            listener.onPhotoClick(position);
                            break;
                        case Message.MSG_TYPE_FACE:
                            listener.onFaceClick(position);
                            break;
                    }
                }
            });
        }

        //消息发送的状态
        switch (data.getState()) {
            case Message.MSG_STATE_FAIL:
                holder.progress.setVisibility(View.GONE);
                holder.img_sendfail.setVisibility(View.VISIBLE);
                break;
            case Message.MSG_STATE_SUCCESS:
                holder.progress.setVisibility(View.GONE);
                holder.img_sendfail.setVisibility(View.GONE);
                break;
            case Message.MSG_STATE_SENDING:
                holder.progress.setVisibility(View.VISIBLE);
                holder.img_sendfail.setVisibility(View.GONE);
                break;
        }
        return v;
    }

    static class ViewHolder {
        TextView tv_date;
        ImageView img_avatar;
        TextView tv_chatcontent;
        ImageView img_chatimage;
        ImageView img_sendfail;
        ProgressBar progress;
        RelativeLayout layout_content;
    }
}
