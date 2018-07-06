package com.wb.cpedata.data.style;

import android.content.pm.ActivityInfo;

import com.wb.cpedata.data.manifest.PictureImageData;
import com.wb.cpedata.parser.cpestyle.CompatibilityDeviceType;
import com.wb.cpedata.parser.cpestyle.ExperienceMenuMapType;
import com.wb.cpedata.util.Size;

import java.util.HashMap;

public class ExperienceStyle {
	private static final String Tablet = "Tablet";
	private static final String Phone = "Phone";
	private static final String Landscape = "Landscape";
	private static final String Portrait = "Portrait";

	private String experienceId;
	final NodeStyleData[] nodeStyles = new NodeStyleData[4];
	public ExperienceStyle(ExperienceMenuMapType experienceMenuMapType, HashMap<String, NodeStyleData> nodeStyleTypeHashMap){
		experienceId = experienceMenuMapType.getExperienceID().get(0).toString();
		for (ExperienceMenuMapType.NodeStyleRef nodeStyleRef : experienceMenuMapType.getNodeStyleRef()){

			String nodeStyleId = nodeStyleRef.getNodeStyleID();
			NodeStyleData nodeStyleData = nodeStyleTypeHashMap.get(nodeStyleId);

			String orientation = nodeStyleRef.getOrientation();
			if (orientation == null) {
				nodeStyles[0] = nodeStyleData;
			}else if (nodeStyleRef.getDeviceTarget() != null && nodeStyleRef.getDeviceTarget().size() > 0){
				for (CompatibilityDeviceType deviceType : nodeStyleRef.getDeviceTarget()){
					int nodeStyleIndex = 0;
					if (Phone.equals(deviceType.getSubClass().get(0))){
						nodeStyleIndex = 0;
					} else if (Tablet.equals(deviceType.getSubClass().get(0)))
						nodeStyleIndex = 2;

					nodeStyleIndex += orientation.equals(Portrait) ? 0 : 1;

					nodeStyles[nodeStyleIndex] = nodeStyleData;
				}
			}

		}
	}

	public String getExperienceId(){
		return experienceId;
	}

	public NodeStyleData getNodeStyleData(int orientation, boolean isTablet){
		int nodeStyleIndex = isTablet ? 2 :0;
		if (orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE || orientation == ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE)
			nodeStyleIndex = nodeStyleIndex + 1;
		NodeStyleData styleData = nodeStyles[nodeStyleIndex];
		if (styleData != null)
			return styleData;
		else if (nodeStyleIndex == 1 || nodeStyleIndex == 3){
			if (nodeStyles[nodeStyleIndex - 1] != null)
				return nodeStyles[nodeStyleIndex - 1];
			else if (nodeStyles[0] != null)
				return nodeStyles[0];
		}
		return null;
	}

	public NodeBackground getBackground(){
		if (nodeStyles[0] != null && nodeStyles[0].background != null){
			return nodeStyles[0].background;
		} else
			return null;
	}

	public String getBackgroundVideoUrl(){
		if (nodeStyles[0] != null && nodeStyles[0].background != null){
			return nodeStyles[0].background.getVideoUrl();
		} else
			return null;
	}

	public String getBackgroundAudioUrl(){
		if (nodeStyles[0] != null && nodeStyles[0].background != null){
			return nodeStyles[0].background.getAudioUrl();
		} else
			return null;
	}

	public Size getBackgroundVideoSize(){
		if (nodeStyles[0] != null && nodeStyles[0].background != null){
			return nodeStyles[0].background.getVideoPresetSize();
		} else
			return null;
	}

	public PictureImageData getBackgroundImage(){
		if (nodeStyles[0] != null && nodeStyles[0].background != null){
			return nodeStyles[0].background.getImage();
		} else
			return null;
	}
}
