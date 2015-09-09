package com.example.expandablelistview_demo.model;

/**
 * @author »ªÃ÷
 *
 */
public class GroupP {
	private String name;
	private Integer imageResId;

	public GroupP() {
	}

	public GroupP(String name, Integer imageResId) {
		super();
		this.name = name;
		this.imageResId = imageResId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getImageResId() {
		return imageResId;
	}

	public void setImageResId(Integer imageResId) {
		this.imageResId = imageResId;
	}

}
