import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

public class Main {
	@Resource(lookup = "jms/ConnectionFactory")
	private static ConnectionFactory connectionFactory;
	@Resource(lookup = "jms/Queue")
	private static Queue queue;
	@Resource(lookup = "jms/Topic")
	private static Topic topic;

	public static void main(String[] args) throws JMSException {

		final int NUM_MSGS = 1;
		String destType = "queue";//args[0];
		/*-System.out.println("Destination type is " + destType);
		if (!(destType.equals("queue") || destType.equals("topic"))) {
			System.err.println("Argument must be \"queue\" or " + "\"topic\"");
			System.exit(1);
		}
		if (args.length == 2) {
			NUM_MSGS = (new Integer(args[1])).intValue();
		} else {
			NUM_MSGS = 1;
		}*/

		Destination dest = null;
		try {
			if (destType.equals("queue")) {
				dest = (Destination) queue;
			} else {
				dest = (Destination) topic;
			}
		} catch (Exception e) {
			System.err.println("Error setting destination: " + e.toString());
			e.printStackTrace();
			System.exit(1);
		}
		Connection connection = connectionFactory.createConnection();
		try {
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(dest);
			TextMessage message = session.createTextMessage();
			for (int i = 0; i < NUM_MSGS; i++) {
				message.setText("This is message " + (i + 1) + " from producer");
				System.out.println("Sending message: " + message.getText());
				producer.send(message);
				// sends an empty control message indicating end of message
				// stream.
				producer.send(session.createMessage());
			}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
				}
			}
		}
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}