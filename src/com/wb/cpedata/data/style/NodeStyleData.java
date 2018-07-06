package com.wb.cpedata.data.style;

import com.wb.cpedata.data.manifest.PictureImageData;
import com.wb.cpedata.parser.cpestyle.BackgroundOverlayAreaType;
import com.wb.cpedata.parser.cpestyle.NodeStyleType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryAudioType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryVideoType;
import com.wb.cpedata.parser.manifest.schema.v1_4.PictureGroupType;
import com.wb.cpedata.parser.manifest.schema.v1_4.PresentationType;
import com.wb.cpedata.util.utils.StringHelper;

import java.util.HashMap;

public class NodeStyleData {
	public final NodeBackground background;
	public final ThemeData theme;
	String themeId;
	public final String nodeStyleId;
	public NodeStyleData(NodeStyleType nodeStyleType, HashMap<String, ThemeData> themeTypeHashMap,
						 HashMap<String, PictureGroupType> pictureGroupAssetsMap,
						 HashMap<String, PictureImageData> pictureImageMap,
						 HashMap<String, PresentationType> presentationAssetMap,
						 HashMap<String, InventoryVideoType> videoAssetsMap,
						 HashMap<String, InventoryAudioType> audioAssetsMap){
		nodeStyleId = nodeStyleType.getNodeStyleID();
		themeId = nodeStyleType.getThemeID();
		if (!StringHelper.isEmpty(themeId)){
			theme = themeTypeHashMap.get(themeId);
		}else
			theme = null;

		if (nodeStyleType.getBackground() != null) {
			background = new NodeBackground(nodeStyleType.getBackground(), pictureGroupAssetsMap, pictureImageMap, presentationAssetMap, videoAssetsMap, audioAssetsMap);
		}else
			background = null;
	}

	public BackgroundOverlayAreaType getButtonOverlayArea(){
		if (background != null)
			return background.buttonOverlayArea;
		else
			return null;
	}

	public BackgroundOverlayAreaType getTitleOverlayArea(){
		if (background != null)
			return background.titleOverlayArea;
		else
			return null;
	}
}
