package Week9Exercise;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by tolly on 3/27/2017.
 */
public class HelloWorldTag extends SimpleTagSupport {

    /**
     * This method overrides the regular doTag to place a custom
     * message for the tag this class represents.
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        out.println(calculateTimedMessage());
    }

    /**
     * This method returns a different message dependant
     * on the time of day. Returns a seasonal greeting
     * for Halloween.
     * @return the returned message
     */
    public String calculateTimedMessage() {
        String timedMessage = "";

        Calendar calendar = Calendar.getInstance();

        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        if (currentHour < 12) {
            timedMessage = "Good Morning.";
        } else if (currentHour < 16) {
            timedMessage = "Good Afternoon.";
        } else if (currentHour < 20) {
            timedMessage = "Good Evening.";
        } else {
            timedMessage = "Good Night.";
        }

        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH);
        if (currentDay == 31 && currentMonth == 10) {
            timedMessage += " Happy Halloween!";
        }

        return timedMessage;
    }
}
