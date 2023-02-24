package Org.Paramount.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils {

    public String getDateTime(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return dateFormat.format(date);

    }

    public Logger log(){ //utils method to use log in all the classes. command to get class name Thread.currentThread().getStackTrace() [2].getClassName()

        return LogManager.getLogger(Thread.currentThread().getStackTrace() [2].getClassName());

    }

}
