package com.muzhi.emojisdk.emoji;

import android.view.KeyEvent;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import com.muzhi.emojisdk.model.EmojiInfo;

/**
 * emoji数组及显示的相关方法
 *
 * @author Jazzy
 */
public class EmojiDatas {

	public static final EmojiInfo[] datas = new EmojiInfo[]{
			
			EmojiInfo.fromCodePoint(0x1f604),
            EmojiInfo.fromCodePoint(0x1f603),
            EmojiInfo.fromCodePoint(0x1f600),
            EmojiInfo.fromCodePoint(0x1f60a),
            EmojiInfo.fromChar((char) 0x263a),
            EmojiInfo.fromCodePoint(0x1f609),
            EmojiInfo.fromCodePoint(0x1f60d),
            EmojiInfo.fromCodePoint(0x1f618),
            EmojiInfo.fromCodePoint(0x1f61a),
            EmojiInfo.fromCodePoint(0x1f617),
            EmojiInfo.fromCodePoint(0x1f619),
            EmojiInfo.fromCodePoint(0x1f61c),
            EmojiInfo.fromCodePoint(0x1f61d),
            EmojiInfo.fromCodePoint(0x1f61b),
            EmojiInfo.fromCodePoint(0x1f633),
            EmojiInfo.fromCodePoint(0x1f601),
            EmojiInfo.fromCodePoint(0x1f614),
            EmojiInfo.fromCodePoint(0x1f60c),
            EmojiInfo.fromCodePoint(0x1f612),
            EmojiInfo.fromCodePoint(0x1f61e),
            EmojiInfo.fromCodePoint(0x1f623),
            EmojiInfo.fromCodePoint(0x1f622),
            EmojiInfo.fromCodePoint(0x1f602),
            EmojiInfo.fromCodePoint(0x1f62d),
            EmojiInfo.fromCodePoint(0x1f62a),
            EmojiInfo.fromCodePoint(0x1f625),
            EmojiInfo.fromCodePoint(0x1f630),
            
            EmojiInfo.fromCodeByte(0xf0, 0x9f, 0x94, 0x99), //删除按钮
            
            EmojiInfo.fromCodePoint(0x1f605),
            EmojiInfo.fromCodePoint(0x1f613),
            EmojiInfo.fromCodePoint(0x1f629),
            EmojiInfo.fromCodePoint(0x1f62b),
            EmojiInfo.fromCodePoint(0x1f628),
            EmojiInfo.fromCodePoint(0x1f631),
            EmojiInfo.fromCodePoint(0x1f620),
            EmojiInfo.fromCodePoint(0x1f621),
            EmojiInfo.fromCodePoint(0x1f624),
            EmojiInfo.fromCodePoint(0x1f616),
            EmojiInfo.fromCodePoint(0x1f606),
            EmojiInfo.fromCodePoint(0x1f60b),
            EmojiInfo.fromCodePoint(0x1f637),
            EmojiInfo.fromCodePoint(0x1f60e),
            EmojiInfo.fromCodePoint(0x1f634),
            EmojiInfo.fromCodePoint(0x1f635),
            EmojiInfo.fromCodePoint(0x1f632),
            EmojiInfo.fromCodePoint(0x1f61f),
            EmojiInfo.fromCodePoint(0x1f626),
            EmojiInfo.fromCodePoint(0x1f627),
            EmojiInfo.fromCodePoint(0x1f608),
            EmojiInfo.fromCodePoint(0x1f47f),
            EmojiInfo.fromCodePoint(0x1f62e),
            EmojiInfo.fromCodePoint(0x1f62c),
            EmojiInfo.fromCodePoint(0x1f610),
            EmojiInfo.fromCodePoint(0x1f615),
            EmojiInfo.fromCodePoint(0x1f62f),
            
            EmojiInfo.fromCodeByte(0xf0, 0x9f, 0x94, 0x99),
            
            EmojiInfo.fromCodePoint(0x1f636),
            EmojiInfo.fromCodePoint(0x1f607),
            EmojiInfo.fromCodePoint(0x1f60f),
            EmojiInfo.fromCodePoint(0x1f611),
            EmojiInfo.fromCodePoint(0x1f472),
            EmojiInfo.fromCodePoint(0x1f473),
            EmojiInfo.fromCodePoint(0x1f46e),
            EmojiInfo.fromCodePoint(0x1f477),
            EmojiInfo.fromCodePoint(0x1f482),
            EmojiInfo.fromCodePoint(0x1f476),
            EmojiInfo.fromCodePoint(0x1f466),
            EmojiInfo.fromCodePoint(0x1f467),
            EmojiInfo.fromCodePoint(0x1f468),
            EmojiInfo.fromCodePoint(0x1f469),
            EmojiInfo.fromCodePoint(0x1f474),
            EmojiInfo.fromCodePoint(0x1f475),
            EmojiInfo.fromCodePoint(0x1f471),
            EmojiInfo.fromCodePoint(0x1f47c),
            EmojiInfo.fromCodePoint(0x1f478),
            EmojiInfo.fromCodePoint(0x1f63a),
            EmojiInfo.fromCodePoint(0x1f638),
            EmojiInfo.fromCodePoint(0x1f63b),
            EmojiInfo.fromCodePoint(0x1f63d),
            EmojiInfo.fromCodePoint(0x1f63c),
            EmojiInfo.fromCodePoint(0x1f640),
            EmojiInfo.fromCodePoint(0x1f63f),
            EmojiInfo.fromCodePoint(0x1f639),
            
            EmojiInfo.fromCodeByte(0xf0, 0x9f, 0x94, 0x99),
            
            EmojiInfo.fromCodePoint(0x1f63e),
            EmojiInfo.fromCodePoint(0x1f479),
            EmojiInfo.fromCodePoint(0x1f47a),
            EmojiInfo.fromCodePoint(0x1f648),
            EmojiInfo.fromCodePoint(0x1f649),
            EmojiInfo.fromCodePoint(0x1f64a),
            EmojiInfo.fromCodePoint(0x1f480),
            EmojiInfo.fromCodePoint(0x1f47d),
            EmojiInfo.fromCodePoint(0x1f4a9),
            EmojiInfo.fromCodePoint(0x1f525),
            EmojiInfo.fromChar((char) 0x2728),
            EmojiInfo.fromCodePoint(0x1f31f),
            EmojiInfo.fromCodePoint(0x1f4ab),
            EmojiInfo.fromCodePoint(0x1f4a5),
            EmojiInfo.fromCodePoint(0x1f4a2),
            EmojiInfo.fromCodePoint(0x1f4a6),
            EmojiInfo.fromCodePoint(0x1f4a7),
            EmojiInfo.fromCodePoint(0x1f4a4),
            EmojiInfo.fromCodePoint(0x1f4a8),
            EmojiInfo.fromCodePoint(0x1f442),
            EmojiInfo.fromCodePoint(0x1f440),
            EmojiInfo.fromCodePoint(0x1f443),
            EmojiInfo.fromCodePoint(0x1f445),
            EmojiInfo.fromCodePoint(0x1f444),
            EmojiInfo.fromCodePoint(0x1f44d),
            EmojiInfo.fromCodePoint(0x1f44e),
            EmojiInfo.fromCodePoint(0x1f44c),
            
            EmojiInfo.fromCodeByte(0xf0, 0x9f, 0x94, 0x99),
            
            EmojiInfo.fromCodePoint(0x1f44a),
            EmojiInfo.fromChar((char) 0x270a),
            EmojiInfo.fromChar((char) 0x270c),
            EmojiInfo.fromCodePoint(0x1f44b),
            EmojiInfo.fromChar((char) 0x270b),
            EmojiInfo.fromCodePoint(0x1f450),
            EmojiInfo.fromCodePoint(0x1f446),
            EmojiInfo.fromCodePoint(0x1f447),
            EmojiInfo.fromCodePoint(0x1f449),
            EmojiInfo.fromCodePoint(0x1f448),
            EmojiInfo.fromCodePoint(0x1f64c),
            EmojiInfo.fromCodePoint(0x1f64f),
            EmojiInfo.fromChar((char) 0x261d),
            EmojiInfo.fromCodePoint(0x1f44f),
            EmojiInfo.fromCodePoint(0x1f4aa),
            EmojiInfo.fromCodePoint(0x1f6b6),
            EmojiInfo.fromCodePoint(0x1f3c3),
            EmojiInfo.fromCodePoint(0x1f483),
            EmojiInfo.fromCodePoint(0x1f46b),
            EmojiInfo.fromCodePoint(0x1f46a),
            EmojiInfo.fromCodePoint(0x1f46c),
            EmojiInfo.fromCodePoint(0x1f46d),
            EmojiInfo.fromCodePoint(0x1f48f),
            EmojiInfo.fromCodePoint(0x1f491),
            EmojiInfo.fromCodePoint(0x1f46f),
            EmojiInfo.fromCodePoint(0x1f646),
            EmojiInfo.fromCodePoint(0x1f645),
            
            EmojiInfo.fromCodeByte(0xf0, 0x9f, 0x94, 0x99),
            
            EmojiInfo.fromCodePoint(0x1f481),
            EmojiInfo.fromCodePoint(0x1f64b),
            EmojiInfo.fromCodePoint(0x1f486),
            EmojiInfo.fromCodePoint(0x1f487),
            EmojiInfo.fromCodePoint(0x1f485),
            EmojiInfo.fromCodePoint(0x1f470),
            EmojiInfo.fromCodePoint(0x1f64e),
            EmojiInfo.fromCodePoint(0x1f64d),
            EmojiInfo.fromCodePoint(0x1f647),
            EmojiInfo.fromCodePoint(0x1f3a9),
            EmojiInfo.fromCodePoint(0x1f451),
            EmojiInfo.fromCodePoint(0x1f452),
            EmojiInfo.fromCodePoint(0x1f45f),
            EmojiInfo.fromCodePoint(0x1f45e),
            EmojiInfo.fromCodePoint(0x1f461),
            EmojiInfo.fromCodePoint(0x1f460),
            EmojiInfo.fromCodePoint(0x1f462),
            EmojiInfo.fromCodePoint(0x1f455),
            EmojiInfo.fromCodePoint(0x1f454),
            EmojiInfo.fromCodePoint(0x1f45a),
            EmojiInfo.fromCodePoint(0x1f457),
            EmojiInfo.fromCodePoint(0x1f3bd),
            EmojiInfo.fromCodePoint(0x1f456),
            EmojiInfo.fromCodePoint(0x1f458),
            EmojiInfo.fromCodePoint(0x1f459),
            EmojiInfo.fromCodePoint(0x1f4bc),
            EmojiInfo.fromCodePoint(0x1f45c),
            
            EmojiInfo.fromCodeByte(0xf0, 0x9f, 0x94, 0x99),
            
            EmojiInfo.fromCodePoint(0x1f45d),
            EmojiInfo.fromCodePoint(0x1f45b),
            EmojiInfo.fromCodePoint(0x1f453),
            EmojiInfo.fromCodePoint(0x1f380),
            EmojiInfo.fromCodePoint(0x1f302),
            EmojiInfo.fromCodePoint(0x1f484),
            EmojiInfo.fromCodePoint(0x1f49b),
            EmojiInfo.fromCodePoint(0x1f499),
            EmojiInfo.fromCodePoint(0x1f49c),
            EmojiInfo.fromCodePoint(0x1f49a),
            EmojiInfo.fromChar((char) 0x2764),
            EmojiInfo.fromCodePoint(0x1f494),
            EmojiInfo.fromCodePoint(0x1f497),
            EmojiInfo.fromCodePoint(0x1f493),
            EmojiInfo.fromCodePoint(0x1f495),
            EmojiInfo.fromCodePoint(0x1f496),
            EmojiInfo.fromCodePoint(0x1f49e),
            EmojiInfo.fromCodePoint(0x1f498),
            EmojiInfo.fromCodePoint(0x1f48c),
            EmojiInfo.fromCodePoint(0x1f48b),
            EmojiInfo.fromCodePoint(0x1f48d),
            EmojiInfo.fromCodePoint(0x1f48e),
            EmojiInfo.fromCodePoint(0x1f464),
            EmojiInfo.fromCodePoint(0x1f465),
            EmojiInfo.fromCodePoint(0x1f4ac),
            EmojiInfo.fromCodePoint(0x1f463),
            EmojiInfo.fromCodePoint(0x1f4ad),
            
            EmojiInfo.fromCodeByte(0xf0, 0x9f, 0x94, 0x99),
            
            
			/*Emojicon.fromCodePoint(0x1f436),
            Emojicon.fromCodePoint(0x1f43a),
            Emojicon.fromCodePoint(0x1f431),
            Emojicon.fromCodePoint(0x1f42d),
            Emojicon.fromCodePoint(0x1f439),
            Emojicon.fromCodePoint(0x1f430),
            Emojicon.fromCodePoint(0x1f438),
            Emojicon.fromCodePoint(0x1f42f),
            Emojicon.fromCodePoint(0x1f428),
            Emojicon.fromCodePoint(0x1f43b),
            Emojicon.fromCodePoint(0x1f437),
            Emojicon.fromCodePoint(0x1f43d),
            Emojicon.fromCodePoint(0x1f42e),
            Emojicon.fromCodePoint(0x1f417),
            Emojicon.fromCodePoint(0x1f435),
            Emojicon.fromCodePoint(0x1f412),
            Emojicon.fromCodePoint(0x1f434),
            Emojicon.fromCodePoint(0x1f411),
            Emojicon.fromCodePoint(0x1f418),
            Emojicon.fromCodePoint(0x1f43c),
            Emojicon.fromCodePoint(0x1f427),
            Emojicon.fromCodePoint(0x1f426),
            Emojicon.fromCodePoint(0x1f424),
            Emojicon.fromCodePoint(0x1f425),
            Emojicon.fromCodePoint(0x1f423),
            Emojicon.fromCodePoint(0x1f414),
            Emojicon.fromCodePoint(0x1f40d),
            Emojicon.fromCodePoint(0x1f422),*/
            
    };
	
	 public static List<EmojiInfo> getAllByType() {
	        List<EmojiInfo> list = new ArrayList<EmojiInfo>();
	        for(int i=0;i<datas.length;i++){
	        	 EmojiInfo emoji = new EmojiInfo();
	        	 emoji.setEmojiValue(datas[i].getEmojiValue());
	        	 emoji.setCode(datas[i].getCode());
	        	 list.add(emoji);
	        }
	        return list;
	      
	 }
	 
	 public static final String newString(int codePoint) {
		 if(Character.charCount(codePoint) == 1) {
			 return String.valueOf(codePoint);
		 }
		 else{
			 return new String(Character.toChars(codePoint));
		 }
	 }
	 
	 public static boolean isDeleteEmojicon(EmojiInfo emoji) {
		 boolean ret=false;
		 if(emoji!=null && emoji.getCode()!=null){
			 byte[] codes = new byte[]{(byte)0xf0, (byte)0x9f, (byte)0x94, (byte)0x99};
			 String v=new String(codes);
			 ret=v.equals(emoji.getEmojiValue());
		 }
		 return ret;
	 }
	 
	 public static void backspace(EditText editText) {
		 if (editText == null) {
			 return;
		 }
         KeyEvent event = new KeyEvent(0, 0, 0, KeyEvent.KEYCODE_DEL, 0, 0, 0,0, KeyEvent.KEYCODE_ENDCALL);
	     editText.dispatchKeyEvent(event);
	 }
}
