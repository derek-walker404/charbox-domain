package co.charbox.domain.model;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobSchedule {
	
	private String name;
	private String schedule;
	
	public static JobSchedule newHeartbeatJob() {
		return JobSchedule.builder()
				.name("job.heartbeat.interval")
				.schedule(CronSchedule.builder()
						.seconds(Interval.getRandom(0, 60))
						.minutes(Interval.getAll())
						.hours(Interval.getAll())
						.dayOfWeek(Interval.getAll())
						.dayOfMonth(Interval.getAll())
						.build()
						.toString())
				.build();
	}
	
	public static JobSchedule newPingResultJob() {
		return JobSchedule.builder()
				.name("job.ping_results.interval")
				.schedule(CronSchedule.builder()
						.seconds(Interval.getRandom(0, 60))
						.minutes(Interval.getRandomInterval(20))
						.hours(Interval.getAll())
						.dayOfWeek(Interval.getAll())
						.dayOfMonth(Interval.getAll())
						.build()
						.toString())
				.build();
	}
	
	public static JobSchedule newSstJob() {
		return JobSchedule.builder()
				.name("job.sst.interval")
				.schedule(CronSchedule.builder()
						.seconds(Interval.getRandom(0, 60))
						.minutes(Interval.getRandom(0, 60))
						.hours(Interval.getRandomInterval(3))
						.dayOfWeek(Interval.getAll())
						.dayOfMonth(Interval.getAll())
						.build()
						.toString())
				.build();
	}
	
	public static JobSchedule newUpgradeJob() {
		return JobSchedule.builder()
				.name("job.upgrade.interval")
				.schedule(CronSchedule.builder()
						.seconds(Interval.getRandom(0, 60))
						.minutes(Interval.getRandom(0, 60))
						.hours(Interval.getAll())
						.dayOfWeek(Interval.getAll())
						.dayOfMonth(Interval.getAll())
						.build()
						.toString())
				.build();
	}
	
	public static List<JobSchedule> getAllJobs() {
		return Lists.newArrayList(newHeartbeatJob(), newPingResultJob(), newSstJob(), newUpgradeJob());
	}
	
	@Builder
	private static class CronSchedule {
		private Interval seconds = Interval.getAll();
		private Interval minutes = Interval.getAll();
		private Interval hours = Interval.getAll();
		private Interval dayOfWeek = Interval.getAll();
		private Interval dayOfMonth = Interval.getAll();
		
		@Override
		public String toString() {
			return seconds + " " + minutes + " " + hours + " " + dayOfWeek + " " + dayOfMonth + " ?";
		}
	}
	
	@Data
	@Builder
	private static class Interval {
		
		private static final Random rand = new Random();

		private final Integer initial;
		private final Integer interval;
		
		@Override
		public String toString() {
			return safe(getInitial()) +
					(getInterval() == null ? "" : "/" + getInterval());
		}
		
		private String safe(Integer val) {
			return val == null ? "*" : val + "";
		}
		
		public static Interval getAll() {
			return Interval.builder().build();
		}
		
		public static Interval getRandom(int min, int max) {
			return Interval.builder()
					.initial(rand(min, max))
					.build();
		}
		
		public static Interval getRandomInterval(int interval) {
			return Interval.builder()
					.initial(rand(0, interval - 1))
					.interval(interval)
					.build();
		}
		
		private static int rand(int min, int max) {
			return rand.nextInt(max - min + 1) + min;
		}
	}
}
