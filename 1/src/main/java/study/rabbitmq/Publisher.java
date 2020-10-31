package study.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.rabbitmq 
 * Publisher.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 6. 14.
 * @author : tobby48
 * @version : v1.0
 */
public class Publisher {

	private final static String QUEUE_NAME = "gajune";

	/**
	 * <pre>
	 * 설명 : 
	 * 변경이력 : 
	 * -----------------------------------------------------------------
	 * 변경일       작성자       변경내용  
	 * ------------ ------------ ---------------------------------------
	 * 2020. 6. 14. tobby48          최초 작성 
	 * -----------------------------------------------------------------
	 * </pre> 
	 * @since : 2020. 6. 14.
	 * @author : tobby48
	 * @param args
	 * @throws IOException
	 * @throws TimeoutException
	 */ 	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("dev-swh.ga");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		
		String message = "Hello World!";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");

		channel.close();
		connection.close();
	}
}