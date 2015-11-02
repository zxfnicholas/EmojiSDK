package com.muzhi.emojisdk.utils;


import com.muzhi.emojisdk.model.EmojiInfo;
import com.muzhi.emojisdk.model.Faceicon;

/**
 * 表情栏顶部按钮的监听器
 *
 * @author Jazzy
 */
public interface OnOperationListener {

    void send(String content);

    void selectedFace(Faceicon content);

    void selectedEmoji(EmojiInfo content);
    
    void selectedBackSpace(EmojiInfo back);

    void selectedFunction(int index);
}
