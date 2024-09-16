package entities.enums;

public enum OrderStatus {

	PENDING_PAYMENT("1","PENDING_PAYMENT"),
	PROCESSING("2", "PROCESSING"),
	SHIPPED("3", "SHIPPED"),
	DELIVERED("4","DELIVERED");
	
	private String statusCode;
	private String statusDescription;
	
	private OrderStatus(String statusCode, String statusDescription) {
		this.statusCode = statusCode;
		this.statusDescription = statusDescription;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	
	public static OrderStatus updateOrderStatus(String statusCode) {
		if(statusCode.equals("1")) {
			return PENDING_PAYMENT; 
		}else if(statusCode.equals("2")) {
			return PROCESSING;
		}else if(statusCode.equals("3")) {
			return SHIPPED;
		}else if(statusCode.equals("4")) {
			return DELIVERED;
		}else {
			return null;
		}
	}
}