package com.workz.pencil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="pencil_info")
@Entity
public class PencilEntity {

	@Id
	@Column(name = "PENCIL_ID")
	private int pencilID;
	
	@Column(name = "pencil_BRAND")
	private String pencilBrand;
	
	@Column(name = "pencil_PRICE")
	private double pencilPrice;
	
	
	@Column(name = "pencil_COLOR")
	private String pencilColor;
	
	@Column(name = "pencil_SIZE")
	private int pencilSize;
	
	@Column(name = "IS_graphite_leaded")
	private boolean isgraphiteleaded;
	
	@Column(name = "soft_eraser")
	private String softeraser;

	public PencilEntity() {
		System.out.println("default constuctor");
	}
	
	@Override
	public String toString() {
		return "PencilEntity [pencilID=" + pencilID + ", pencilBrand=" + pencilBrand + ", pencilPrice=" + pencilPrice
				+ ", pencilColor=" + pencilColor + ", pencilSize=" + pencilSize + ", isgraphiteleaded="
				+ isgraphiteleaded + ", softeraser=" + softeraser + "]";
	}

	public int getPencilID() {
		return pencilID;
	}

	public void setPencilID(int pencilID) {
		this.pencilID = pencilID;
	}

	public String getPencilBrand() {
		return pencilBrand;
	}

	public void setPencilBrand(String pencilBrand) {
		this.pencilBrand = pencilBrand;
	}

	public double getPencilPrice() {
		return pencilPrice;
	}

	public void setPencilPrice(double pencilPrice) {
		this.pencilPrice = pencilPrice;
	}

	public String getPencilColor() {
		return pencilColor;
	}

	public void setPencilColor(String pencilColor) {
		this.pencilColor = pencilColor;
	}

	public int getPencilSize() {
		return pencilSize;
	}

	public void setPencilSize(int pencilSize) {
		this.pencilSize = pencilSize;
	}

	public boolean isIsgraphiteleaded() {
		return isgraphiteleaded;
	}

	public void setIsgraphiteleaded(boolean isgraphiteleaded) {
		this.isgraphiteleaded = isgraphiteleaded;
	}

	public String getSofteraser() {
		return softeraser;
	}

	public void setSofteraser(String softeraser) {
		this.softeraser = softeraser;
	}

	public PencilEntity(int pencilID, String pencilBrand, double pencilPrice, String pencilColor, int pencilSize,
			boolean isgraphiteleaded, String softeraser) {
		super();
		this.pencilID = pencilID;
		this.pencilBrand = pencilBrand;
		this.pencilPrice = pencilPrice;
		this.pencilColor = pencilColor;
		this.pencilSize = pencilSize;
		this.isgraphiteleaded = isgraphiteleaded;
		this.softeraser = softeraser;
	}
	
	
}
