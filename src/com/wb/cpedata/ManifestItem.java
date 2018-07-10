package com.wb.cpedata;

public class ManifestItem {
	private final String manifestFileUrl;
	private final String ngeStyleFileUrl;
	private final String appDataFileUrl;

	public ManifestItem(String manifestFileUrl, String appDataFileUrl, String ngeStyleFileUrl){
		this.manifestFileUrl = manifestFileUrl;
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
