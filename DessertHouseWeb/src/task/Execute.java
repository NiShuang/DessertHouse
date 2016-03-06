package task;

import java.text.ParseException;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Execute extends Thread{
	public static boolean isStart=false;
	
	public void run() { 
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = null;
		try {
			sched = sf.getScheduler();
		} catch (SchedulerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 

		try {
			@SuppressWarnings({ "unused", "rawtypes" })
			Class statisticsJob = Class.forName("task.TimingJob");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JobDetail job = JobBuilder.newJob(TimingJob.class).withIdentity("job1", "group1").build();
		Trigger trigger = null;
		try {
			trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
					          .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 * * ? *"))   /////"0 0 0 * * ? *"
					          .build();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			sched.scheduleJob(job, trigger);
		} catch (SchedulerException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			sched.start();
		} catch (SchedulerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
