/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: History model-setters and getters for view history fields
 * Date: 05/09/2020
 * File: HistoryModel.java*/

package models;

public class HistoryModel {
	// private String bDateId;
	private String FromId;
	private String ToId;
	private String DateId;
	private String TimeId;
	private String ClassId;
	private String LNameId;
	private String BookId;

	/**
	 * @return the BookId
	 */
	public String getBookId() {
		return BookId;
	}

	/**
	 * @param txtZipcode the BookId to set
	 */
	public void setBookId(String BookId) {
		this.BookId = BookId;
	}

	/**
	 * @return the lNameId
	 */
	public String getLNameId() {
		return LNameId;
	}

	/**
	 * @param lNameId the lNameId to set
	 */
	public void setLNameId(String lNameId) {
		LNameId = lNameId;
	}

	/**
	 * @return the fromId
	 */
	public String getFromId() {
		return FromId;
	}

	/**
	 * @param fromId the fromId to set
	 */
	public void setFromId(String fromId) {
		FromId = fromId;
	}

	/**
	 * @return the toId
	 */
	public String getToId() {
		return ToId;
	}

	/**
	 * @param toId the toId to set
	 */
	public void setToId(String toId) {
		ToId = toId;
	}

	/**
	 * @return the dateId
	 */
	public String getDateId() {
		return DateId;
	}

	/**
	 * @param dateId the dateId to set
	 */
	public void setDateId(String dateId) {
		DateId = dateId;
	}

	/**
	 * @return the timeId
	 */
	public String getTimeId() {
		return TimeId;
	}

	/**
	 * @param timeId the timeId to set
	 */
	public void setTimeId(String timeId) {
		TimeId = timeId;
	}

	/**
	 * @return the classId
	 */
	public String getClassId() {
		return ClassId;
	}

	/**
	 * @param classId the classId to set
	 */
	public void setClassId(String classId) {
		ClassId = classId;
	}

}
