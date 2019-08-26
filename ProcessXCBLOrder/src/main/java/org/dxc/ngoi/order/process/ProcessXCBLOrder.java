package org.dxc.ngoi.order.process;

import org.springframework.beans.factory.annotation.Autowired;

public class ProcessXCBLOrder {
	
	@Autowired
	OrderMappingServiceClient orderMappingServiceClient;
	
	@Autowired
	ValidateOrderServiceClient validateOrderServiceClient;
	
	@Autowired
	TransactionDataServiceClient transactionDataServiceClient;
	
	public boolean processOrder(String xcblOrder)
	{
		OrderMappingRequest orderMappingRequest = new OrderMappingRequest();
		orderMappingRequest.setSourceFormat("XCBL");
		orderMappingRequest.setTargetFormat("GSXML");
		orderMappingRequest.setOrderDoc(xcblOrder);
		OrderMappingResponse orderMappingResponse = orderMappingServiceClient.mapOrder(orderMappingRequest);
		if(orderMappingResponse.statusCode.equals("200") {
		
			ValidateOrderRequest validateOrderRequest = new ValidateOrderRequest();
			validateOrderRequest.setInputDoc(orderMappingResponse.getOutputDoc());
			
			validateOrderServiceClient.validateOrder(validateOrderRequest);
			
			
		}
			
		
		return true;
	}

}
