package com.wb.cpedata.data.theTake;

import com.wb.cpedata.data.manifest.ShopItemInterface;

import java.util.List;

public class ShopCategory {
	public int categoryId;
	public String categoryName;
	public List<ShopCategory> childCategories;
	public List<ShopItemInterface> products;
}
