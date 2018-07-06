package com.wb.cpedata.data.manifest;

import com.wb.cpedata.parser.manifest.schema.v1_4.AppGroupType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryInteractiveType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InteractiveItem {
	final public String type;
	final public String encoding;
	final public String assetLocation;
	final public String runtimeEnvironment;
	final public List<String> environmentAttribute = new ArrayList<>();

	public InteractiveItem(AppGroupType appGroupType, HashMap<String, InventoryInteractiveType> inventoryAssetsMap) {
		if (appGroupType.getInteractiveTrackReference() != null &&
				appGroupType.getInteractiveTrackReference().size() > 0) {
			String interactiveId = appGroupType.getInteractiveTrackReference().get(0).getInteractiveTrackID();

			InventoryInteractiveType inventoryType = inventoryAssetsMap.get(interactiveId);

			type = inventoryType.getType();
			encoding = (inventoryType.getEncoding() != null && inventoryType.getEncoding().size() > 0) ? inventoryType.getEncoding().get(0).getRuntimeEnvironment() : "";
			assetLocation = inventoryType.getContainerReference() != null ? inventoryType.getContainerReference().getContainerLocation() : "";

			if (appGroupType.getInteractiveTrackReference().get(0).getCompatibility().size() > 0) {
				runtimeEnvironment = appGroupType.getInteractiveTrackReference().get(0).getCompatibility().get(0).getRuntimeEnvironment();
				if ( appGroupType.getInteractiveTrackReference().get(0).getCompatibility().get(0).getEnvironmentAttribute() != null){
					environmentAttribute.addAll(appGroupType.getInteractiveTrackReference().get(0).getCompatibility().get(0).getEnvironmentAttribute());
				}
			} else
				runtimeEnvironment = "";

		} else {
			type = "";
			encoding = "";
			assetLocation = "";
			runtimeEnvironment = "";
		}
	}

	public boolean isAppDataItem(){
		return "other".equals(type);
	}

	public String[] getOrientations(){
		if (environmentAttribute.size() > 0){
			return environmentAttribute.toArray(new String[environmentAttribute.size()]);
		}
		return new String[0];
	}
}
