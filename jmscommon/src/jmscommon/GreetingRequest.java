package jmscommon;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Serializable type which holds the session state.
 *
 * @author rwatsh
 */
public class GreetingRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Calendar requestTime;
    private String greeting;

    public GreetingRequest(String greet) {
        requestTime = Calendar.getInstance();
        greeting = greet;
    }

    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat();
        String ds = df.format(requestTime.getTime());
        return "jmscommon.GreetingRequest [requestTime=" + ds + ", greeting=" + greeting + "]";
    }
}