package com.wb.cpedata;

public class ManifestItem {
	public final String imageUrl;
	public final String movieName;
	private final String manifestFileUrl;
	private final String ngeStyleFileUrl;
	private final String appDataFileUrl;
	public final String contentId;

	public ManifestItem(String movieName, String cid, String imageUrl, String manifestFileUrl, String appDataFileUrl, String ngeStyleFileUrl){
		this.imageUrl = imageUrl;
		contentId = cid;
		this.manifestFileUrl = manifestFileUrl;
		this.movieName = movieName;
		this.appDataFileUrl = appDataFileUrl;
		this.ngeStyleFileUrl = ngeStyleFileUrl;
	}

	public String getManifestFileUrl(){
		return manifestFileUrl;
	}

	public String getAppDataFileUrl(){
		return appDataFileUrl;
	}

	public String getNgeStyleFileUrl(){
		return ngeStyleFileUrl;
	}
}