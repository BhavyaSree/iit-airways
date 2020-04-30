package models;

import java.time.LocalDate;

public class FlightsModel 
{
	
	// instance fields
	private String txtFrom;
	private String txtTo;
	private LocalDate txtDate;
	private String txtClass;
	private String fromId;
	private String toId;
	private String dateId;
	private String timeId;
	private String classId;
	private String priceId;
	
	
	//Getters and Setters for the fields

	/**
	 * @return the txtFrom
	 */
	public String getTxtFrom() {
		return txtFrom;
	}
	/**
	 * @param txtFrom the txtFrom to set
	 */
	public void setTxtFrom(String txtFrom) {
		this.txtFrom = txtFrom;
	}
	/**
	 * @return the txtTo
	 */
	public String getTxtTo() {
		return txtTo;
	}
	/**
	 * @param txtTo the txtTo to set
	 */
	public void setTxtTo(String txtTo) {
		this.txtTo = txtTo;
	}
	/**
	 * @return the txtDate
	 */
	public LocalDate getTxtDate() {
		return txtDate;
	}
	/**
	 * @param txtDate the txtDate to set
	 */
	public void setTxtDate(LocalDate txtDate) {
		this.txtDate = txtDate;
	}
	/**
	 * @return the txtClass
	 */
	public String getTxtClass() {
		return txtClass;
	}
	/**
	 * @param txtClass the txtClass to set
	 */
	public void setTxtClass(String txtClass) {
		this.txtClass = txtClass;
	}
	/**
	 * @return the fromId
	 */
	public String getFromId() {
		return fromId;
	}
	/**
	 * @param fromId the fromId to set
	 */
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	/**
	 * @return the toId
	 */
	public String getToId() {
		return toId;
	}
	/**
	 * @param toId the toId to set
	 */
	public void setToId(String toId) {
		this.toId = toId;
	}
	/**
	 * @return the dateId
	 */
	public String getDateId() {
		return dateId;
	}
	/**
	 * @param dateId the dateId to set
	 */
	public void setDateId(String dateId) {
		this.dateId = dateId;
	}
	/**
	 * @return the timeId
	 */
	public String getTimeId() {
		return timeId;
	}
	/**
	 * @param timeId the timeId to set
	 */
	public void setTimeId(String timeId) {
		this.timeId = timeId;
	}
	/**
	 * @return the classId
	 */
	public String getClassId() {
		return classId;
	}
	/**
	 * @param classId the classId to set
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}
	/**
	 * @return the priceId
	 */
	public String getPriceId() {
		return priceId;
	}
	/**
	 * @param priceId the priceId to set
	 */
	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}
	
	
	
}