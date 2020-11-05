package com.wopiro.distri.tasks.cloud;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTasks {

	static public void start() {
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {			
			public void run() {				
				backup();
				log();
			}
		}, 0, 1000 * 60 * 30);

	}

	static private void backup() {
		System.out.println("Backup:");
		LocalTime now = LocalTime.now();
		System.out.println(now);
		System.out.println("=====================================");
	}

	static private void log() {
		System.out.println("Logs:");
		LocalTime now = LocalTime.now();
		System.out.println(now);
		System.out.println("=====================================");
	}

}
