package org.dxc.ngoi.order.process;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "validateorder")
public interface ValidateOrderServiceClient {
	
	
	@PostMapping(path="/order/validate") 
	public ValidateOrderResponse validateOrder(ValidateOrderRequest orderMappingRequest);	
	
		
}
