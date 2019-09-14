package org.dxc.ngoi.order.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class XCBLOrderConsumer {

	@Autowired
	TransactionDataServiceClient transactionDataServiceClient;
	
	@Autowired
	@Qualifier("processXCBLOrder")
	ProcessXCBLOrder processXCBLOrder;
	
	private final Logger logger = LoggerFactory.getLogger(XCBLOrderConsumer.class);

    @KafkaListener(topics = "${xcblorder.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
		
		  TransactionLog transactionLog = new TransactionLog();
		  transactionLog.setRequestMsg(message);
		  transactionLog.setReceivedDate(getFormatedDate("yyyy-MM-dd HH:mm:ss"));
		  transactionDataServiceClient.addNewTransactionLog(transactionLog);
		     
        processXCBLOrder.processOrder(message);
        
        
    }
    
    private String getFormatedDate(String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(new Date());
			
	}	
}
