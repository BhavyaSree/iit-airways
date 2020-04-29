package models;

public class TicketDetailsModel {

		// instance fields
	    private String txtUsername;
		private String lblLname;
		private String lblFname;
		private long lblPhone;
		private String lblEmail;
		private String lblDate;
		private String lblTime;
		private String lblFrom;
		private String lblTo;
		private String lblClass;
		private String lblStatus;
		private Integer lblBookingId;
		//private String txtBookingId;

		// Getters and Setters for the fields

		/**
		 * @return the txtUname
		 */
		public String gettxtUsername() 
		{
			return txtUsername;
		}
		
		/**
		 * @param txtUname the txtUname to set
		 */
		public void settxtUsername(String txtUsername) 
		{
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
		 * @return the txtDob
		 */
		public String getlblDate() {
			return lblDate;
		}

		/**
		 * @param txtDob the txtDob to set
		 */
		public void setlblDate(String lblDate) {
			this.lblDate = lblDate;
		}
		
		/**
		 * @return the txtDob
		 */
		public String getlblTime() {
			return lblTime;
		}

		/**
		 * @param txtDob the txtDob to set
		 */
		public void setlblTime(String lblTime) {
			this.lblTime = lblTime;
		}


		/**
		 * @return the txtAddress
		 */
		public String getlblTo() {
			return lblTo;
		}

		/**
		 * @param txtAddress the txtAddress to set
		 */
		public void setlblTo(String lblTo) {
			this.lblTo = lblTo;
		}

		/**
		 * @return the txtCity
		 */
		public String getlblFrom() {
			return lblFrom;
		}

		/**
		 * @param txtCity the txtCity to set
		 */
		public void setlblFrom(String lblFrom) {
			this.lblFrom = lblFrom;
		}

		/**
		 * @return the txtState
		 */
		public String getlblClass() {
			return lblClass;
		}

		/**
		 * @param txtState the txtState to set
		 */
		public void setlblClass(String lblClass) {
			this.lblClass = lblClass;
		}

		/**
		 * @return the txtZipcode
		 */
		public Integer getlblBookingId() {
			return lblBookingId;
		}

		/**
		 * @param txtZipcode the txtZipcode to set
		 */
		public void setlblBookingId(Integer lblBookingId) {
			this.lblBookingId = lblBookingId;
		}

		/**
		 * @return the txtEmail
		 */
		public String getlblEmail() {
			return lblEmail;
		}

		/**
		 * @param txtEmail the txtEmail to set
		 */
		public void setlblEmail(String lblEmail) {
			this.lblEmail = lblEmail;
		}

		/**
		 * @return the txtPhone
		 */
		public long getlblPhone() {
			return lblPhone;
		}

		/**
		 * @param txtPhone the txtPhone to set
		 */
		public void setlblPhone(long lblPhone) {
			this.lblPhone = lblPhone;
		}
		
		/**
		 * @return the txtEmail
		 */
		public String getlblStatus() {
			return lblStatus;
		}

		/**
		 * @param txtEmail the txtEmail to set
		 */
		public void setlblStatus(String lblStatus) {
			this.lblStatus = lblStatus;
		}
	}

