package com.jgeschwa.fileimporter.sftp.messageHandler;

import com.jgeschwa.fileimporter.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContentHandler implements org.springframework.messaging.MessageHandler {

    private final PersonService service;

    @Override
    @ServiceActivator(inputChannel = "data", adviceChain = "after")
    public void handleMessage(Message<?> message) throws MessagingException {
        service.doImport(message.getPayload().toString());
        System.out.println("Import for file " + message.getHeaders().get("file_remoteFile") +
                " was successful.");
    }
}
