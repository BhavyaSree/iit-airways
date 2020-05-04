/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: TicketView model-setters and getters for Ticket View fields
 * Date: 05/09/2020
 * File: TicketViewModel.java*/

package models;

public class TicketViewModel {

	// instance fields
	private String txtUsername;
	private String lblLname;
	private String lblFname;
	private String lblPrice;
	private long lblPhone;
	private String lblEmail;
	private String lblDate;
	private String lblTime;
	private String lblFrom;
	private String lblTo;
	private String lblClass;
	private String lblStatus;
	private Integer lblBookingId;
	// private String txtBookingId;

	// Getters and Setters for the fields

	/**
	 * @return the txtUname
	 */
	public String gettxtUsername() {
		return txtUsername;
	}

	/**
	 * @param txtUname the txtUname to set
	 */
	public void settxtUsername(String txtUsername) {
		this.txtUsername = txtUsername;
	}

	/**
	 * @return the txtLname
	 */
	public String getlblLname() {
		return lblLname;
	}

	/**
	 * @param txtLname the txtLname to set
	 */
	public void setlblLname(String lblLname) {
		this.lblLname = lblLname;
	}

	/**
	 * @return the txtFname
	 */
	public String getlblFname() {
		return lblFname;
	}

	/**
	 * @param txtFname the txtFname to set
	 */
	public void setlblFname(String lblFname) {
		this.lblFname = lblFname;
	}

	/**
	 * @return the txtDate
	 */
	public String getlblDate() {
		return lblDate;
	}

	/**
	 * @param txtDob the txtDate to set
	 */
	public void setlblDate(String lblDate) {
		this.lblDate = lblDate;
	}

	/**
	 * @return the lblTime
	 */
	public String getlblTime() {
		return lblTime;
	}

	/**
	 * @param lblTime the lblTime to set
	 */
	public void setlblTime(String lblTime) {
		this.lblTime = lblTime;
	}

	/**
	 * @return the lblTo
	 */
	public String getlblTo() {
		return lblTo;
	}

	/**
	 * @param lblTo the lblTo to set
	 */
	public void setlblTo(String lblTo) {
		this.lblTo = lblTo;
	}

	/**
	 * @return the lblFrom
	 */
	public String getlblFrom() {
		return lblFrom;
	}

	/**
	 * @param lblFrom the lblFrom to set
	 */
	public void setlblFrom(String lblFrom) {
		this.lblFrom = lblFrom;
	}

	/**
	 * @return the lblClass
	 */
	public String getlblClass() {
		return lblClass;
	}

	/**
	 * @param lblClass the lblClass to set
	 */
	public void setlblClass(String lblClass) {
		this.lblClass = lblClass;
	}

	/**
	 * @return the lblBookingId
	 */
	public Integer getlblBookingId() {
		return lblBookingId;
	}

	/**
	 * @param lblBookingId the lblBookingId to set
	 */
	public void setlblBookingId(Integer lblBookingId) {
		this.lblBookingId = lblBookingId;
	}

	/**
	 * @return the lblPrice
	 */
	public String getlblPrice() {
		return lblPrice;
	}

	/**
	 * @param lblPrice the lblPrice to set
	 */
	public void setlblPrice(String lblPrice) {
		this.lblPrice = lblPrice;
	}

	/**
	 * @return the lblEmail
	 */
	public String getlblEmail() {
		return lblEmail;
	}

	/**
	 * @param lblEmail the lblEmail to set
	 */
	public void setlblEmail(String lblEmail) {
		this.lblEmail = lblEmail;
	}

	/**
	 * @return the lblPhone
	 */
	public long getlblPhone() {
		return lblPhone;
	}

	/**
	 * @param lblPhone the lblPhone to set
	 */
	public void setlblPhone(long lblPhone) {
		this.lblPhone = lblPhone;
	}

	/**
	 * @return the lblStatus
	 */
	public String getlblStatus() {
		return lblStatus;
	}

	/**
	 * @param lblStatus the lblStatus to set
	 */
	public void setlblStatus(String lblStatus) {
		this.lblStatus = lblStatus;
	}
}
