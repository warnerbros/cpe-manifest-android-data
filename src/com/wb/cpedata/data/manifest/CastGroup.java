package com.wb.cpedata.data.manifest;

import com.wb.cpedata.CPEDataParser;
import com.wb.cpedata.util.utils.StringHelper;

import java.util.ArrayList;
import java.util.List;

public class CastGroup {
	final List<CastData> castsList = new ArrayList<CastData>();
	private String groupTitle;
	final public String groupJob;
	public CastGroup(String job){
		groupJob = job;
	}

	public String getGroupTitle(){
		if (!StringHelper.isEmpty(groupTitle))
			return groupTitle;
		if (!castsList.isEmpty()){
			groupTitle = CPEDataParser.getCPEData().peopleIdToTalentGroupNameMap.get(castsList.get(0).getOtherPeopleId());
		}

		if (StringHelper.isEmpty(groupTitle)){
			groupTitle = "Cast & Crew";
		}
		return groupTitle;
	}

	public List<CastData> getCastsList(){
		return castsList;
	}
}
