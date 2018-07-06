package com.wb.cpedata.data.manifest;

import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryAudioType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryVideoType;

class AudioVisualTrack {
	public final InventoryVideoType videoData;
	public final InventoryAudioType audioData;
	public AudioVisualTrack(InventoryVideoType videoData, InventoryAudioType audioData){
		this.videoData = videoData;
		this.audioData = audioData;
	}

	public String getVideoUrl(){
		if (videoData != null)
			return  videoData.getContainerReference().getContainerLocation();
		else
			return null;
	}

	public String getAudioUrl(){
		if (audioData != null)
			return  audioData.getContainerReference().getContainerLocation();
		else
			return null;
	}
}
