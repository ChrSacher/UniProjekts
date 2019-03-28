package whz.pti.eva.pizzaservice.pizza.boundary;

public class UserCustomerNotFoundException extends Exception
{
    private String message;
    private String email;
    private String requestSite;
    /**
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }
    /**
     * @param message the message to set
     */
    public void setMessage(String message)
    {
        this.message = message;
    }
    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * @return the requestSite
     */
    public String getRequestSite()
    {
        return requestSite;
    }
    /**
     * @param message
     * @param email
     * @param requestSite
     */
    public UserCustomerNotFoundException(String message, String email, String requestSite)
    {
	super();
	this.message = message;
	this.email = email;
	this.requestSite = requestSite;
    }
    /**
     * @param requestSite the requestSite to set
     */
    public void setRequestSite(String requestSite)
    {
        this.requestSite = requestSite;
    }

}
