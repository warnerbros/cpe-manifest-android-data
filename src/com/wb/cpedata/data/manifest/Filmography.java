package com.wb.cpedata.data.manifest;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Filmography {
	@SerializedName("CHARACTER_NAME")
	public String characterName;
	@SerializedName("PROJECT_NAME")
	public String title;
	@SerializedName("PROJECT_ID")
	public String projectId;
	@SerializedName("ROLE")
	public String role;
	@SerializedName("SORT_ORDER")
	public int sortOrder;
	@SerializedName("ROLE_GROUP")
	public String roleGroup;

	@SerializedName("POSTERS")
	public List<FilmPoster> filmPosters;

	public String getFilmPosterImageUrl(){
		if (filmPosters !=  null && filmPosters.size() > 0)
			return filmPosters.get(0).mediumUrl;
		else
			return "";
	}

	public boolean isFilmPosterRequest(){
		return filmPosters != null;
	}

	public String movieInfoUrl;
}
