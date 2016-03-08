package net.dummy.backend.batch.scheduler;

import java.util.Properties;

import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class DummyTimer implements Timer {

	@Override
	@Schedule(minute = "*/5")
	public void runJob() {
		System.out.println("DummyTime - runJob()");
		BatchRuntime.getJobOperator().start("dummyJob", new Properties());
	}

}
