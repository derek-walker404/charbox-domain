package co.charbox.domain.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.apache.commons.lang.NotImplementedException;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceVersionModel implements IPersistentModel<DeviceVersionModel, String>, Comparable<DeviceVersionModel> {

	private String id;
	private String version;
	private Long versionSort;
	private String installScriptUrl;
	
	public Long getVersionSort() {
		if (this.versionSort == null) {
			this.versionSort = new Version(getVersion()).getVersionSort();
		}
		return versionSort;
	}
	
	/**
	 * Set automatically the first time {@link #getVersionSort()} is called.
	 * @param newVersionSort
	 * @throws NotImplementedException
	 */
	public void setVersionSort(Long newVersionSort) {
		this.versionSort = newVersionSort;
	}
	
	public int compareTo(DeviceVersionModel o) {
		return o == null ? -1 : getVersionSort().compareTo(o.getVersionSort());
	}
	
	@Getter
	private static class Version {
		private int release;
		private int major;
		private int minor;
		private Character candidate;
		
		private static final Pattern nonCandidatePattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)$");
		private static final Pattern candidatePattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)(a|b|rc)$");
		
		public Version(String version) {
			Matcher m = nonCandidatePattern.matcher(version);
			if (m.find()) {
				parseNonCandidate(m);
			} else {
				m = candidatePattern.matcher(version);
				if (m.find()) {
					parseCandidate(m);
				} else {
					throw new IllegalArgumentException("Invalid Version: " + version);
				}
			}
		}
		
		public long getVersionSort() {
			String sort = pad(getRelease())
					+ pad(getMajor())
					+ pad(getMinor());
			if (getCandidate() == null) {
				sort += "4";
			} else {
				switch (getCandidate()) {
				case 'a':
					sort += "1";
					break;
				case 'b':
					sort += "2";
					break;
				case 'r':
					sort += "3";
					break;
				}
			}
			return Long.parseLong(sort);
		}

		private String pad(int val) {
			String s = val + "";
			while (s.length() < 4) {
				s = "0" + s;
			}
			return s;
		}
		
		private void parseNonCandidate(Matcher m) {
			this.release = Integer.parseInt(m.group(1));
			this.major = Integer.parseInt(m.group(2));
			this.minor = Integer.parseInt(m.group(3));
		}
		
		private void parseCandidate(Matcher m) {
			this.release = Integer.parseInt(m.group(1));
			this.major = Integer.parseInt(m.group(2));
			this.minor = Integer.parseInt(m.group(3));
			this.candidate = m.group(4).charAt(0);
		}
	}
}
