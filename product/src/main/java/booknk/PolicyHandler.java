package booknk;

import booknk.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceledDelivery_(@Payload CanceledDelivery canceledDelivery){

        if(canceledDelivery.isMe()){
            System.out.println("##### listener  : " + canceledDelivery.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDelivered_(@Payload Delivered delivered){

        if(delivered.isMe()){
            System.out.println("##### listener  : " + delivered.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceledDelivery_(@Payload CanceledDelivery canceledDelivery){

        if(canceledDelivery.isMe()){
            System.out.println("##### listener  : " + canceledDelivery.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookRegistered_(@Payload BookRegistered bookRegistered){

        if(bookRegistered.isMe()){
            System.out.println("##### listener  : " + bookRegistered.toJson());
        }
    }

}
