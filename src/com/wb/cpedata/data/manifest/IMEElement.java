package com.wb.cpedata.data.manifest;

public class IMEElement<T> {
	public final long startTimecode;
	public final long endTimecode;
	public final T imeObject;
	public final int itemIndex;
	public IMEElement(long startTimecode, long endTimeCode, T imeObject, int itemIndex){   // in millisecond
		this.startTimecode = startTimecode;
		this.endTimecode = endTimeCode;
		this.imeObject = imeObject;
		this.itemIndex = itemIndex;
	}

	/*
		returns: 0 = within
		returns: >0 = after
		returns: <0 = before
	 */
	public int compareTimeCode(long timeCode){
		long beforeTime = timeCode - startTimecode;
		long afterTime = timeCode - endTimecode;
		if (beforeTime >=0 && afterTime <= 0)
			return 0;
		else if (afterTime > 0)
			return 1;
		else
			return -1;
	}
}
