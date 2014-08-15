/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author rwatsh
 */
public class GreetingRequest implements Serializable {

    private Calendar requestTime;
    private String greeting;

    public GreetingRequest(String greet) {
        requestTime = Calendar.getInstance();
        greeting = greet;
    }

    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat();
        String ds = df.format(requestTime.getTime());
        return "helloworld.vo.GreetingRequest [requestTime=" + ds + ", greeting=" + greeting + "]";
    }
}
