package models;

import java.time.LocalDate;

public class Customer 
{

	// instance fields
		private String txtLname;
		private String txtFname;
		private LocalDate dob;
		private String txtEmail;
		private long txtPhone;
		private String txtAddress;
		private String txtCity;
		private String txtState;
		private String txtZipcode;		
		
	//Getters and Setters for the fields
		
		/**
		 * @return the txtLname
		 */
		public String getTxtLname() {
			return txtLname;
		}

		/**
		 * @param txtLname the txtLname to set
		 */
		public void setTxtLname(String txtLname) {
			this.txtLname = txtLname;
		}

		/**
		 * @return the txtFname
		 */
		public String getTxtFname() {
			return txtFname;
		}

		/**
		 * @param txtFname the txtFname to set
		 */
		public void setTxtFname(String txtFname) {
			this.txtFname = txtFname;
		}

		/**
		 * @return the dob
		 */
		public LocalDate getDob() {
			return dob;
		}

		/**
		 * @param dob the dob to set
		 */
		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		/**
		 * @return the txtAddress
		 */
		public String getTxtAddress() {
			return txtAddress;
		}

		/**
		 * @param txtAddress the txtAddress to set
		 */
		public void setTxtAddress(String txtAddress) {
			this.txtAddress = txtAddress;
		}

		/**
		 * @return the txtCity
		 */
		public String getTxtCity() {
			return txtCity;
		}

		/**
		 * @param txtCity the txtCity to set
		 */
		public void setTxtCity(String txtCity) {
			this.txtCity = txtCity;
		}

		/**
		 * @return the txtState
		 */
		public String getTxtState() {
			return txtState;
		}

		/**
		 * @param txtState the txtState to set
		 */
		public void setTxtState(String txtState) {
			this.txtState = txtState;
		}

		/**
		 * @return the txtZipcode
		 */
		public String getTxtZipcode() {
			return txtZipcode;
		}

		/**
		 * @param txtZipcode the txtZipcode to set
		 */
		public void setTxtZipcode(String txtZipcode) {
			this.txtZipcode = txtZipcode;
		}

		/**
		 * @return the txtEmail
		 */
		public String getTxtEmail() {
			return txtEmail;
		}

		/**
		 * @param txtEmail the txtEmail to set
		 */
		public void setTxtEmail(String txtEmail) {
			this.txtEmail = txtEmail;
		}

		/**
		 * @return the txtPhone
		 */
		public long getTxtPhone() {
			return txtPhone;
		}

		/**
		 * @param txtPhone the txtPhone to set
		 */
		public void setTxtPhone(long txtPhone) {
			this.txtPhone = txtPhone;
		}
}
