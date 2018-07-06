package com.wb.cpedata.data.theTake;

import android.content.Context;

import com.google.gson.annotations.SerializedName;
import com.wb.cpedata.R;
import com.wb.cpedata.data.manifest.ShopItemInterface;

public class TheTakeProduct implements ShopItemInterface {
	@SerializedName(value="cropImage", alternate={"cropImages"})
	public FrameImages cropImage;
	@SerializedName(value="productImage", alternate={"productImages"})
	public FrameImages productImage;
	@SerializedName(value="keyFrameImage", alternate={"keyFrameImages", "frameImages"})
	public FrameImages keyFrameImage;
	public String characterId;
	public String actorId;
	public boolean verified;
	public float keyCropProductY;
	public float keyCropProductX;
	public String actorName;
	public String mediaId;
	public String productBrand;
	@SerializedName("unavailable")
	public int bUnavailable;
	public String characterName;
	public boolean soldOut;
	public String mediaName;
	public String purchaseLink;
	public float trendingScore;
	public long keyFrameImageTime;
	public long productId;
	public float keyFrameProductX;
	public float keyFrameProductY;
	public String productPrice;
	public String productName;

	private TheTakeProductDetail productDetail;

	public String getShopItemText(Context context){
		return context.getResources().getString(R.string.shop_at_the_take);
	}

	public String getThumbnailUrl(){
		if (cropImage != null)
			return cropImage.image500px;
		else if (keyFrameImage != null)
			return keyFrameImage.image500px;
		else
			return "";
	}

	public String getProductThumbnailUrl(){
		if (productImage != null)
			return productImage.image500px;
		else
			return "";
	}

	public String getProductName(){
		return productName;
	}

	public String getProductBrand(){
		return productBrand;
	}

	public boolean isVerified(){
		return verified;
	}

	public float getKeyCropProductY(){
		return keyCropProductY;
	}

	public float getKeyCropProductX(){
		return keyCropProductX;
	}

	public TheTakeProductDetail getProductDetail(){
		return productDetail;
	}

	public void setProductDetail(TheTakeProductDetail detail){
		productDetail = detail;
	}

	public long getProductId(){
		return productId;
	}

	public String getProductReportId(){
		return Long.toString(productId);
	}

	public String getShareLinkUrl(){
		if (productDetail != null)
			return productDetail.shareUrl;
		return "";
	}

	public String getPurchaseLinkUrl(){
		if (productDetail != null)
			return productDetail.purchaseLink;
		return "";
	}
}
