package models;

public class User 
{
	// instance fields	
	private String txtUname;
	private String txtPassword;
		
	//Getters and Setters for the fields		
	/**
	 * @return the txtUname
	 */
	public String getTxtUname() 
	{
		return txtUname;
	}

	/**
	 * @param txtUname the txtUname to set
	 */
	public void setTxtUname(String txtUname) 
	{
		this.txtUname = txtUname;
	}

	/**
	 * @return the txtPassword
	 */
	public String getTxtPassword() 
	{
		return txtPassword;
	}

	/**
	 * @param txtPassword the txtPassword to set
	 */
	public void setTxtPassword(String txtPassword) 
	{
		this.txtPassword = txtPassword;
	}
}
