package io.github.sergejsvisockis.bookmanager.producer;

import io.github.sergejsvisockis.bookmanager.lib.BookEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookProducer {

    private final String queueName;
    private final JmsTemplate jmsTemplate;

    public BookProducer(@Value("${book.queue}") String queueName,
                        JmsTemplate jmsTemplate) {
        this.queueName = queueName;
        this.jmsTemplate = jmsTemplate;
    }

    public void enqueue(BookEvent event) {
        jmsTemplate.convertAndSend(queueName, event);
    }

}
