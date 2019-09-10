package org.dxc.ngoi.order.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class XCBLOrderConsumer {

	@Autowired
	TransactionDataServiceClient transactionDataServiceClient;
	
	@Autowired
	ProcessXCBLOrder processXCBLOrder;
	
	private final Logger logger = LoggerFactory.getLogger(XCBLOrderConsumer.class);

    @KafkaListener(topics = "${cloudkarafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        TransactionLog transactionLog = new TransactionLog();
        transactionLog.setRequestMsg(message);
        transactionLog.setReceivedDate("2019-03-22 16:06:40");
        transactionDataServiceClient.addNewTransactionLog(transactionLog);
        
        processXCBLOrder.processOrder(message);
        
        
    }
}
