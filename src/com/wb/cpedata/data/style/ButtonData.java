package com.wb.cpedata.data.style;

import com.wb.cpedata.CPEDataParser;
import com.wb.cpedata.data.manifest.PictureImageData;
import com.wb.cpedata.parser.cpestyle.ButtonType;

import java.util.HashMap;

public class ButtonData {
	public final static int BASE = 0;
	public final static int HIGHLIGHT = 1;
	public final static int DEFOCUS = 2;
	public final String label;
	final PictureImageData[] buttomImageList = new PictureImageData[3];

	public ButtonData(ButtonType buttonType, HashMap<String, PictureImageData> pictureImageMap){

		label = buttonType.getLabel();
		boolean bLocalizedFound = false;
		if (buttonType.getLocalized() != null && buttonType.getLocalized().size() > 0){
			for(ButtonType.Localized localized : buttonType.getLocalized()){
				if (CPEDataParser.matchesClientLocale(localized.getLanguage())){

					buttomImageList[BASE] = pictureImageMap.get(localized.getBaseImage());
					buttomImageList[HIGHLIGHT] = pictureImageMap.get(localized.getHighlightImage());
					buttomImageList[DEFOCUS] = pictureImageMap.get(localized.getDefocusImage());
					bLocalizedFound = true;
				}
			}
		}

		if (!bLocalizedFound && buttonType.getDefault() != null){
			buttomImageList[BASE] = pictureImageMap.get(buttonType.getDefault().getBaseImage());
			buttomImageList[HIGHLIGHT] = pictureImageMap.get(buttonType.getDefault().getHighlightImage());
			buttomImageList[DEFOCUS] = pictureImageMap.get(buttonType.getDefault().getDefocusImage());
		}
	}
}
