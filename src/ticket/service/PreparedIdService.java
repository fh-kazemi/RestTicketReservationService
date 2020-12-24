package ticket.service;

import java.util.Calendar;
import java.util.Random;

public class PreparedIdService {
    public static int prepareId(int firstNumber, int endNumber) {
        Calendar c = Calendar.getInstance();
        int id = (c.get(Calendar.YEAR) + c.get(Calendar.MONTH) + c.get(Calendar.DAY_OF_MONTH)
                + c.get(Calendar.HOUR) + c.get(Calendar.MINUTE) + c.get(Calendar.SECOND)
                + Math.abs(new Random().nextInt())) % endNumber;
        if (id < firstNumber) {
            id += firstNumber;
        }
        return id;
    }
}
