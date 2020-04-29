package models;

import java.time.LocalDate;
public class Admin {


		// instance fields
	    private String atxtUsername;
		private String atxtLname;
		private String atxtFname;
		private LocalDate atxtDob;
		private String atxtEmail;
		private long atxtPhone;
		private String atxtAddress;
		private String atxtCity;
		private String atxtState;
		private String atxtZipcode;

		// Getters and Setters for the fields


		/**
		 * @return the txtUname
		 */
		public String getatxtUsername() 
		{
			return atxtUsername;
		}
		
		/**
		 * @param txtUname the txtUname to set
		 */
		public void setatxtUsername(String atxtUsername) 
		{
			this.atxtUsername = atxtUsername;
		}
		
		/**
		 * @return the txtLname
		 */
		public String getatxtLname() {
			return atxtLname;
		}

		/**
		 * @param txtLname the txtLname to set
		 */
		public void setatxtLname(String atxtLname) {
			this.atxtLname = atxtLname;
		}

		/**
		 * @return the txtFname
		 */
		public String getatxtFname() {
			return atxtFname;
		}

		/**
		 * @param txtFname the txtFname to set
		 */
		public void setatxtFname(String atxtFname) {
			this.atxtFname = atxtFname;
		}

		/**
		 * @return the txtDob
		 */
		public LocalDate getatxtDob() {
			return atxtDob;
		}

		/**
		 * @param txtDob the txtDob to set
		 */
		public void setatxtDob(LocalDate atxtDob) {
			this.atxtDob = atxtDob;
		}

		/**
		 * @return the txtAddress
		 */
		public String getatxtAddress() {
			return atxtAddress;
		}

		/**
		 * @param txtAddress the txtAddress to set
		 */
		public void setatxtAddress(String atxtAddress) {
			this.atxtAddress = atxtAddress;
		}

		/**
		 * @return the txtCity
		 */
		public String getatxtCity() {
			return atxtCity;
		}

		/**
		 * @param txtCity the txtCity to set
		 */
		public void setatxtCity(String atxtCity) {
			this.atxtCity = atxtCity;
		}

		/**
		 * @return the txtState
		 */
		public String getatxtState() {
			return atxtState;
		}

		/**
		 * @param txtState the txtState to set
		 */
		public void setatxtState(String atxtState) {
			this.atxtState = atxtState;
		}

		/**
		 * @return the txtZipcode
		 */
		public String getatxtZipcode() {
			return atxtZipcode;
		}

		/**
		 * @param txtZipcode the txtZipcode to set
		 */
		public void setatxtZipcode(String atxtZipcode) {
			this.atxtZipcode = atxtZipcode;
		}

		/**
		 * @return the txtEmail
		 */
		public String getatxtEmail() {
			return atxtEmail;
		}

		/**
		 * @param txtEmail the txtEmail to set
		 */
		public void setatxtEmail(String atxtEmail) {
			this.atxtEmail = atxtEmail;
		}

		/**
		 * @return the txtPhone
		 */
		public long getatxtPhone() {
			return atxtPhone;
		}

		/**
		 * @param txtPhone the txtPhone to set
		 */
		public void setatxtPhone(long atxtPhone) {
			this.atxtPhone = atxtPhone;
		}
	}


