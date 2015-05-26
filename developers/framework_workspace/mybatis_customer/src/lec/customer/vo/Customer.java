package lec.customer.vo;

public class Customer {
	private String customerId;
	private String customerPassword;
	private String customerName;
	private String customerEmail;
	private String customerPhoneNo;
	private int customerMileage;

	public Customer(String customerId, String customerPassword,
			String customerName, String customerEmail, String customerPhoneNo,
			int customerMileage) {
		super();
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhoneNo = customerPhoneNo;
		this.customerMileage = customerMileage;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the customerPassword
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}

	/**
	 * @param customerPassword
	 *            the customerPassword to set
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail
	 *            the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the customerPhoneNo
	 */
	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	/**
	 * @param customerPhoneNo
	 *            the customerPhoneNo to set
	 */
	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	/**
	 * @return the customerMileage
	 */
	public int getCustomerMileage() {
		return customerMileage;
	}

	/**
	 * @param customerMileage
	 *            the customerMileage to set
	 */
	public void setCustomerMileage(int customerMileage) {
		this.customerMileage = customerMileage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerPassword="
				+ customerPassword + ", customerName=" + customerName
				+ ", customerEmail=" + customerEmail + ", customerPhoneNo="
				+ customerPhoneNo + ", customerMileage=" + customerMileage
				+ "]";
	}

}
