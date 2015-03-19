/*
 * Copyright 2015 ECS Team, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ecsteam.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Josh Ghiloni
 *
 */
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
