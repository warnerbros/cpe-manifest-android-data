package com.wb.cpedata.data.style;

import com.wb.cpedata.data.manifest.PictureImageData;
import com.wb.cpedata.parser.cpestyle.BackgroundOverlayAreaType;
import com.wb.cpedata.parser.cpestyle.BackgroundType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryAudioType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryVideoType;
import com.wb.cpedata.parser.manifest.schema.v1_4.PictureGroupType;
import com.wb.cpedata.parser.manifest.schema.v1_4.PictureType;
import com.wb.cpedata.parser.manifest.schema.v1_4.PresentationType;
import com.wb.cpedata.util.Size;
import com.wb.cpedata.util.utils.StringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NodeBackground {
	private static final String TITLE_TAG = "title";
	private static final String BUTTON_TAG = "button";

	String videoPresentationID;
	String imagePictureGroupID;
	String colorHex;
	StyleData.ScaleMethod scaleMethod;
	StyleData.PositionMethod positionMethod;
	double videoLoopingPoint;
	String videoUrl;
	String audioUrl;
	Size videoSize = null;
	List<PictureImageData> bgImages = new ArrayList<>();

	BackgroundOverlayAreaType buttonOverlayArea, titleOverlayArea;

	public NodeBackground(BackgroundType backgroundType,
						  HashMap<String, PictureGroupType> pictureGroupAssetsMap,
						  HashMap<String, PictureImageData> pictureImageMap,
						  HashMap<String, PresentationType> presentationAssetMap,
						  HashMap<String, InventoryVideoType> videoAssetsMap ,
						  HashMap<String, InventoryAudioType> audioAssetsMap ){
		if (backgroundType != null){
			colorHex = backgroundType.getColor();
			if (backgroundType.getAudioLoop() != null && !StringHelper.isEmpty(backgroundType.getAudioLoop().getAudioTrackID())){
				String audioAssetId = backgroundType.getAudioLoop().getAudioTrackID();

				InventoryAudioType audio = audioAssetsMap.get(backgroundType.getAudioLoop().getAudioTrackID());
				if (audio != null)
					audioUrl = audio.getContainerReference().getContainerLocation();

			}
			if (backgroundType.getVideo() != null) {
				videoPresentationID = backgroundType.getVideo().getPresentationID();
				PresentationType presentation = presentationAssetMap.get(videoPresentationID);
				InventoryVideoType video = videoAssetsMap.get(presentation.getTrackMetadata().get(0).getVideoTrackReference().get(0).getVideoTrackID().get(0));

				if (video != null) {
					videoUrl = video.getContainerReference().getContainerLocation();
					if (video.getPicture() != null){
						videoSize = new Size(video.getPicture().getWidthPixels(), video.getPicture().getHeightPixels());
					}
				}


				if (video != null) {
					videoUrl = video.getContainerReference().getContainerLocation();
					if (video.getPicture() != null){
						videoSize = new Size(video.getPicture().getWidthPixels(), video.getPicture().getHeightPixels());
					}
				}


				if (backgroundType.getVideo().getLoopTimecode() != null)
					videoLoopingPoint = Double.parseDouble(backgroundType.getVideo().getLoopTimecode().getValue());
				else
					videoLoopingPoint = 0;
			}
			if (backgroundType.getImage() != null) {
				imagePictureGroupID = backgroundType.getImage().getPictureGroupID();

				PictureGroupType pictureGroup = pictureGroupAssetsMap.get(imagePictureGroupID);
				if (pictureGroup != null) {
					for (PictureType picture : pictureGroup.getPicture()) {
						PictureImageData imageData = pictureImageMap.get(picture.getImageID());
						bgImages.add(imageData);
					}
				}

			}
			if (backgroundType.getAdaptation() != null){
				scaleMethod = StyleData.ScaleMethod.valueOf(backgroundType.getAdaptation().getScaleMethod());
				positionMethod = StyleData.PositionMethod.valueOf(backgroundType.getAdaptation().getPositioningMethod());
			}
			if (backgroundType.getOverlayArea() != null && backgroundType.getOverlayArea().size() > 0) {
				for (BackgroundOverlayAreaType overlayArea : backgroundType.getOverlayArea()){
					if (TITLE_TAG.equals(overlayArea.getTag()))
						titleOverlayArea = overlayArea;
					else
						buttonOverlayArea = overlayArea;
				}
			}
			//backgroundType.getAdaptation().
		}
	}

	public int getVideoLoopingPoint(){
		return (int)(videoLoopingPoint * 1000.0);
	}

	public String getVideoUrl(){
		return videoUrl;
	}

	public String getAudioUrl(){
		return audioUrl;
	}

	public Size getVideoPresetSize(){
		return videoSize;
	}

	public PictureImageData getImage(){
		if (bgImages.size() > 0)
			return bgImages.get(0);
		else
			return null;
	}

	public boolean hasBGImage(){
		return !StringHelper.isEmpty(imagePictureGroupID);
	}
}

