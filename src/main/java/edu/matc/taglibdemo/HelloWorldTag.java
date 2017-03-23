package edu.matc.taglibdemo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by kvang on 3/16/17.
 */
public class HelloWorldTag extends SimpleTagSupport {

    /**
     * This method determine the hours of the day, then determine
     * what phrase to use for different type of days.
     *
     * @return timeString timeString
     */
    public String determineTimeOfDay() {
        String user = "Java User!";
        String timeString = "";
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour == 0 || hour < 12) {
            timeString = "Good morning, " + user;
        } else if (hour > 12 || hour < 18) {
            timeString = "Good afternoon, " + user;
        } else if (hour > 18 || hour < 21) {
            timeString = "Good evening, " + user;
        } else {
            timeString = "Good night, " + user;
        }
        return timeString;
    }

    /**
     *  This method formats the current time to 12 hr format with AM/PM. Output string to
     *
     * @return
     */
    public String currentTime() {
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
        String ts = "";
        ts = "Current Time is: " + format.format(calender.getTime());

        return ts;
    }

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        out.println("Hello World!");
        out.println("<br/>");
        out.println(currentTime());
        out.println("<br/>");
        out.println(determineTimeOfDay());
    }

}
