package org.dxc.ngoi.order.process;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ordermappingservice")
public interface OrderMappingServiceClient {
	
	
	@PostMapping(path="/order/map") 
	public OrderMappingResponse mapOrder (OrderMappingRequest orderMappingRequest);	
	
		
}
