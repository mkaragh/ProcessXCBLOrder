package org.dxc.ngoi.order.process;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "transactiondataservice")
public interface TransactionDataServiceClient {
	
	
	@PostMapping(path="/TransactionData/add") 
	public TransactionLog addNewTransactionLog (TransactionLog transactionLog);	
	
		
}
