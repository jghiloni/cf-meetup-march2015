package com.ecsteam.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final SimpleDateFormat SDF = new SimpleDateFormat("EEEE, d MMMM yyyy h:mm:ss a");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomeJsp(Model model) {
		
		// convert GMT to local
		Calendar nowCalendar = Calendar.getInstance(TimeZone.getTimeZone("MST7MDT"));
		TimeZone tz = nowCalendar.getTimeZone();
		
		int offset  = tz.getOffset(nowCalendar.getTimeInMillis());
		nowCalendar.add(Calendar.MILLISECOND, offset);
		
		Date now = nowCalendar.getTime();
		
		model.addAttribute("now", SDF.format(now));
		
		return "home";
	}
}
