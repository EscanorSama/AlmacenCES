package com.ces.almacen.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;
import java.util.TimeZone;

@Component
@Slf4j
public class UtilsDate {

    public Date getSqlSysDate(){
        Calendar calendarDate = getSysDateCalendar();
        Date date = Date.valueOf(String.format("%04d-%02d-%02d",calendarDate.get(Calendar.YEAR),(calendarDate.get(Calendar.MONTH)+1),calendarDate.get(Calendar.DAY_OF_MONTH)));
        return date;
    }

    public Calendar getSysDateCalendar(){
        Calendar calendarDate = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        return calendarDate;
    }
}
