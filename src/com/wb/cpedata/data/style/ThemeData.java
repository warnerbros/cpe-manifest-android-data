package com.wb.cpedata.data.style;

import com.wb.cpedata.data.manifest.PictureImageData;
import com.wb.cpedata.parser.cpestyle.ButtonType;
import com.wb.cpedata.parser.cpestyle.ThemeType;

import java.util.HashMap;

public class ThemeData {
	public final static String EXTRA_BUTTON = "Extras";
	public final static String PURCHASE_BUTTON = "Buy";
	public final static String PLAY_BUTTON = "Play";
	public final String themeId;
	public HashMap<String, ButtonData> buttonDatas = new HashMap<>();

	public ThemeData(ThemeType themeType, HashMap<String, PictureImageData> pictureImageMap){
		themeId = themeType.getThemeID();
		if (themeType.getButtonImageSet() != null && themeType.getButtonImageSet().getButton() != null && themeType.getButtonImageSet().getButton().size() > 0){
			for (ButtonType buttonType : themeType.getButtonImageSet().getButton()){
				ButtonData buttonData = new ButtonData(buttonType, pictureImageMap);
				buttonDatas.put(buttonData.label, buttonData);
			}
		}
	}

	public PictureImageData getImageData(String label){
		ButtonData buttonData = buttonDatas.get(label);
		if (buttonData != null)
			return buttonData.buttomImageList[0];
		else
			return null;
	}
}
