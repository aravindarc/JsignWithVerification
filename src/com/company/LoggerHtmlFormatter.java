package com.company;

import java.io.*;
import java.util.logging.*;
import java.util.*;
import java.text.*;
import java.util.logging.Formatter;

public class LoggerHtmlFormatter extends Formatter
{
    public String format(LogRecord rec)
    {
        try
        {
            StringBuffer buf = new StringBuffer(1024);
            buf.append(getTime(rec.getMillis()));
            buf.append(" " + rec.getSourceClassName() + "."
                    + rec.getSourceMethodName() + ": ");
            buf.append("<b>" + formatMessage(rec) + "</b>");
            buf.append("(" + rec.getLevel() + ")");
            buf.append("\n");
            return buf.toString();
        }
        catch(Exception ex)
        {
            System.err.println("Error:" + ex);
            return "";
        }
    }
    public String getTime(long time)
    {
        String format = "yyyy-MM-dd HH:mm:ssSS";
        Locale currentLocale = new Locale("DEU", "DEU");
        java.util.Date today = new java.util.Date(time);
        DateFormat dateFormatter = DateFormat.getDateInstance(
                DateFormat.DEFAULT, currentLocale);
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat(format, currentLocale);
        return formatter.format(today);
    }
    public String getHead(Handler handler)
    {
        return "<html><head><title>Logging: "
                + getTime(System.currentTimeMillis())
                + "</title></head><body><pre>\n";
    }
    public String getTail(Handler handler)
    {
        return "</pre></body></html>\n";
    }
}
