package dateservice.impl;

import java.text.DateFormat;
import java.util.Date;

import dateservice.DateService;

public class DateServiceImpl implements DateService {
	public String getFormattedDate(Date date) {
		return DateFormat.getDateInstance(DateFormat.SHORT).format(date);
	}
}