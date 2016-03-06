package task;

import javax.ejb.EJB;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import service.MemberService;
import service.MemberServiceBean;

public class TimingJob implements Job {
	@EJB MemberService memberService =  new MemberServiceBean();
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("正在执行定时任务"+memberService.timingJob()+"..............");
	}

}
