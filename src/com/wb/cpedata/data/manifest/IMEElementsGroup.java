package com.wb.cpedata.data.manifest;

import java.util.ArrayList;
import java.util.List;

public class IMEElementsGroup<T>{
	public final ExperienceData linkedExperience;
	final List<IMEElement<T>> imeElementsList = new ArrayList<IMEElement<T>>();
	private ExternalApiData externalApiData;
	public void addElement(IMEElement element){
		imeElementsList.add(element);
	}
	public IMEElementsGroup(ExperienceData ecGroupData){
		this.linkedExperience = ecGroupData;
	}

	public void setExtenralApiData(ExternalApiData data){
		externalApiData = data;
	}

	public ExternalApiData getExternalApiData(){
		return externalApiData;
	}

	public List<IMEElement<T>> getIMEElementesList(){
		return  imeElementsList;
	}
	public void init(){};

}