package org.dxc.ngoi.order.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProcessXCBLOrder {
	
	@Autowired
	OrderMappingServiceClient orderMappingServiceClient;
	
	@Autowired
	ValidateOrderServiceClient validateOrderServiceClient;
	
	@Autowired
	TransactionDataServiceClient transactionDataServiceClient;
	
	private final Logger logger = LoggerFactory.getLogger(ProcessXCBLOrder.class);
	
	public boolean processOrder(String xcblOrder)
	{
		
		
		OrderMappingRequest orderMappingRequest = new OrderMappingRequest();
		orderMappingRequest.setSourceFormat("XCBL");
		orderMappingRequest.setTargetFormat("GSXML");
		orderMappingRequest.setOrderDoc(xcblOrder);
		OrderMappingResponse orderMappingResponse = orderMappingServiceClient.mapOrder(orderMappingRequest);
		if(orderMappingResponse.statusCode.equals("200")) {
			
			
			ValidateOrderRequest validateOrderRequest = new ValidateOrderRequest();
			validateOrderRequest.setInputDoc(orderMappingResponse.getOutputDoc());
			
			ValidateOrderResponse validateOrderResponse = validateOrderServiceClient.validateOrder(validateOrderRequest);
			
			if(validateOrderResponse.getStatusCode().equals("200"))
			logger.info("Validate order is successful");
		}
			
		
		return true;
	}

}
