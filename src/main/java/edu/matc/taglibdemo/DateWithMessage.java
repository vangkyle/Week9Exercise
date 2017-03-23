package edu.matc.taglibdemo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by kvang on 3/20/17.
 */
public class DateWithMessage extends SimpleTagSupport {

    public String determineDayOfWeek() {
        String messageString = "";
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case 1:
                messageString = "Sunday";
                break;
            case 2:
                messageString = "Monday";
                break;
            case 3:
                messageString = "Tuesday";
                break;
            case 4:
                messageString = "Wednesday";
                break;
            case 5:
                messageString = "Thursday";
                break;
            case 6:
                messageString = "Friday";
                break;
            case 7:
                messageString = "Saturday";
                break;
        }
        return messageString;
    }

    public String currentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String date = "";

        date = "Today's date is " + format.format(calendar.getTime());

        return date;
    }

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        out.println(currentDate() + " And it's happy " + determineDayOfWeek());
        out.println("<br/>");


    }
}
