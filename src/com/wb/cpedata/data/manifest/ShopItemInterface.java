package com.wb.cpedata.data.manifest;

import android.content.Context;

public interface ShopItemInterface {

	String getShopItemText(Context context);

	String getThumbnailUrl();

	String getProductThumbnailUrl();

	String getProductName();

	String getProductBrand();

	boolean isVerified();

	float getKeyCropProductY();

	float getKeyCropProductX();

	String getShareLinkUrl();

	String getPurchaseLinkUrl();

	long getProductId();

	String getProductReportId();

}
