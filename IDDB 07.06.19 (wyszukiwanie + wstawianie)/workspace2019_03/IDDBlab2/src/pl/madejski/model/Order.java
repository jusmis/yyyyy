package pl.madejski.model;

public class Order{
	
	private Long bookId;
	private Long clientId;
	private Long orderId;
	
	
	public Order(Long orderId, Long bookId, Long clientId){
		this.bookId = bookId;
		this.orderId = orderId;
		this.clientId=clientId;

	}
	
	public Long getBookId() {
		return bookId;
	}
	
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	
	public Long getClientId() {
		return clientId;
	}
	
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
}
