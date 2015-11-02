package com.muzhi.emojisdk.model;

import java.io.Serializable;

/**
 * @author Jazzy
 */
public class EmojiInfo implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private int sysIcon;		//在系统中所代表的值
	private String name; 		//在网络传递中的值
	private byte[] code; 		//在系统中所代表的值
	private String emojiValue;  //code转换为String的值
	
	
	public int getSysIcon() {
		return sysIcon;
	}
	public void setSysIcon(int sysIcon) {
		this.sysIcon = sysIcon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getCode() {
		return code;
	}
	public void setCode(byte[] code) {
		this.code = code;
	}
	public String getEmojiValue() {
		return emojiValue;
	}
	public void setEmojiValue(String emojiValue) {
		this.emojiValue = emojiValue;
	}
	
	
	
	
	
	public static EmojiInfo fromCodePoint(int codePoint) {
        EmojiInfo emoji = new EmojiInfo();
        emoji.emojiValue = newString(codePoint);
        return emoji;
    }
	
	public static EmojiInfo fromChar(char ch) {
        EmojiInfo emoji = new EmojiInfo();
        emoji.emojiValue = Character.toString(ch);
        return emoji;
    }
	
	public static EmojiInfo fromCodeByte(int value1,int value2,int value3,int value4) {
		EmojiInfo emoji = new EmojiInfo();
	    emoji.code=new byte[]{(byte)value1, (byte)value2, (byte)value3, (byte)value4};
	    emoji.emojiValue=new String(emoji.code);
	    return emoji;
	}
	
	
	
	public static final String newString(int codePoint) {
        if (Character.charCount(codePoint) == 1) {
            return String.valueOf(codePoint);
        } else {
            return new String(Character.toChars(codePoint));
        }
    }
	
	
}