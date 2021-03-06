package com.fasthink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 快速入门
 *
 * @author 翟永超
 * @create 2016/11/8.
 * @blog http://blog.fasthink.com
 */
//@EnableBinding(value = {SinkSender.SinkOutput.class})
public class SinkSender {

    private static Logger logger = LoggerFactory.getLogger(HelloApplication.class);

    @Bean
    @InboundChannelAdapter(value = SinkOutput.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timerMessageSource() {
        return () -> new GenericMessage<>(new Date());
    }

    @Transformer(inputChannel = Sink.INPUT, outputChannel = SinkOutput.OUTPUT)
    public Object transform(Date message) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }

    public interface SinkOutput {

        String OUTPUT = "input";

        @Output(SinkOutput.OUTPUT)
        MessageChannel output();

    }
}




