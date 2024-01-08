package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import config.RabbitMQConfig;

public interface OcrService {

    /**
     * Process incoming messages from the RabbitMQ queue, perform OCR, and index the result.
     *
     * @param message     The incoming message content.
     * @param storagePath The storage path of the document.
     * @throws JsonProcessingException If there is an issue processing the JSON content.
     */

    @RabbitListener(queues = RabbitMQConfig.OCR_QUEUE_NAME)
    void processMessage(String message, String storagePath) throws JsonProcessingException;
}
