package org.dxc.ngoi.order.process;



public class TransactionLog {
	
	
	private Integer messageId;
	 

	private String receivedDate;
	
	
	private String customerId;
	
	
	private String orderSource;
	
	
	private String customerPonbr;	 
	
	
	private String requestMsg;
	 
	
	 private String ackMsg; 
	
	
	 private String gsMsg;
	
	
	 private String outgoingMsg;
	
	
	 private String status;
	
	
	 private String server;
	 
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOrderSource() {
		return orderSource;
	}
	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}
	public String getCustomerPonbr() {
		return customerPonbr;
	}
	public void setCustomerPonbr(String customerPonbr) {
		this.customerPonbr = customerPonbr;
	}
	public String getRequestMsg() {
		return requestMsg;
	}
	public void setRequestMsg(String requestMsg) {
		this.requestMsg = requestMsg;
	}
	public String getAckMsg() {
		return ackMsg;
	}
	public void setAckMsg(String ackMsg) {
		this.ackMsg = ackMsg;
	}
	public String getGsMsg() {
		return gsMsg;
	}
	public void setGsMsg(String gsMsg) {
		this.gsMsg = gsMsg;
	}
	public String getOutgoingMsg() {
		return outgoingMsg;
	}
	public void setOutgoingMsg(String outgoingMsg) {
		this.outgoingMsg = outgoingMsg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	

	

}
