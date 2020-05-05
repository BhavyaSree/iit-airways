/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: UserProfile model-setters and getters for User Profile  fields
 * Date: 05/09/2020
 * File: UserProfileModel.java*/

package models;

import java.time.LocalDate;

public class CustomerProfileModel {

	// instance fields
	private String txtUsername;
	private String txtLname;
	private String txtFname;
	private LocalDate txtDob;
	private String txtEmail;
	private long txtPhone;
	private String txtAddress;
	private String txtCity;
	private String txtState;
	private String txtZipcode;

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
	public String gettxtLname() {
		return txtLname;
	}

	/**
	 * @param txtLname the txtLname to set
	 */
	public void settxtLname(String txtLname) {
		this.txtLname = txtLname;
	}

	/**
	 * @return the txtFname
	 */
	public String gettxtFname() {
		return txtFname;
	}

	/**
	 * @param txtFname the txtFname to set
	 */
	public void settxtFname(String txtFname) {
		this.txtFname = txtFname;
	}

	/**
	 * @return the txtDob
	 */
	public LocalDate gettxtDob() {
		return txtDob;
	}

	/**
	 * @param txtDob the txtDob to set
	 */
	public void settxtDob(LocalDate txtDob) {
		this.txtDob = txtDob;
	}

	/**
	 * @return the txtAddress
	 */
	public String gettxtAddress() {
		return txtAddress;
	}

	/**
	 * @param txtAddress the txtAddress to set
	 */
	public void settxtAddress(String txtAddress) {
		this.txtAddress = txtAddress;
	}

	/**
	 * @return the txtCity
	 */
	public String gettxtCity() {
		return txtCity;
	}

	/**
	 * @param txtCity the txtCity to set
	 */
	public void settxtCity(String txtCity) {
		this.txtCity = txtCity;
	}

	/**
	 * @return the txtState
	 */
	public String gettxtState() {
		return txtState;
	}

	/**
	 * @param txtState the txtState to set
	 */
	public void settxtState(String txtState) {
		this.txtState = txtState;
	}

	/**
	 * @return the txtZipcode
	 */
	public String gettxtZipcode() {
		return txtZipcode;
	}

	/**
	 * @param txtZipcode the txtZipcode to set
	 */
	public void settxtZipcode(String txtZipcode) {
		this.txtZipcode = txtZipcode;
	}

	/**
	 * @return the txtEmail
	 */
	public String gettxtEmail() {
		return txtEmail;
	}

	/**
	 * @param txtEmail the txtEmail to set
	 */
	public void settxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}

	/**F
	 * @return the txtPhone
	 */
	public long gettxtPhone() {
		return txtPhone;
	}

	/**
	 * @param txtPhone the txtPhone to set
	 */
	public void settxtPhone(long txtPhone) {
		this.txtPhone = txtPhone;
	}
}
