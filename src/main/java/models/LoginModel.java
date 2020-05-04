/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: Login model-setters and getters for Login view fields
 * Date: 05/09/2020
 * File: LoginyModel.java*/

package models;

public class LoginModel {
	// instance fields
	private String txtUsername;
	private String txtPassword;
	private String UserType;

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
	 * @return the txtPassword
	 */
	public String gettxtPassword() {
		return txtPassword;
	}

	/**
	 * @param txtPassword the txtPassword to set
	 */
	public void settxtPassword(String txtPassword) {
		this.txtPassword = txtPassword;
	}

	/**
	 * @return the UserTypeChoicBox
	 */
	public String getUserType() {
		return UserType;
	}

	/**
	 * @param UserTypethe UserType to set
	 */
	public void setUserType(String UserType) {
		this.UserType = UserType;
	}
}
