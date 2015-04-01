package co.charbox.domain.model;

import co.charbox.domain.model.mm.ConnectionInfoModel;

public class SSTResults {

	private String deviceId;
	private String deviceKey;
	private long testStartTime; 
	private int downloadSize;
	private int downloadDuration;
	private double downloadSpeed;
	private int uploadSize;
	private int uploadDuration;
	private double uploadSpeed;
	private int pingDuration;
	private ConnectionInfoModel deviceInfo;
	private MyLocation serverLocation;

	public String getDeviceId() {
		return deviceId;
	}

	public SSTResults setDeviceId(String deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	public String getDeviceKey() {
		return deviceKey;
	}

	public SSTResults setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
		return this;
	}

	public long getTestStartTime() {
		return testStartTime;
	}

	public SSTResults setTestStartTime(long testStartTime) {
		this.testStartTime = testStartTime;
		return this;
	}

	public int getDownloadSize() {
		return downloadSize;
	}

	public SSTResults setDownloadSize(int downloadSize) {
		this.downloadSize = downloadSize;
		return this;
	}

	public int getDownloadDuration() {
		return downloadDuration;
	}

	public SSTResults setDownloadDuration(int downloadDuration) {
		this.downloadDuration = downloadDuration;
		return this;
	}

	public double getDownloadSpeed() {
		return downloadSpeed;
	}

	public SSTResults setDownloadSpeed(double downloadSpeed) {
		this.downloadSpeed = downloadSpeed;
		return this;
	}

	public int getUploadSize() {
		return uploadSize;
	}

	public SSTResults setUploadSize(int uploadSize) {
		this.uploadSize = uploadSize;
		return this;
	}

	public int getUploadDuration() {
		return uploadDuration;
	}

	public SSTResults setUploadDuration(int uploadDuration) {
		this.uploadDuration = uploadDuration;
		return this;
	}

	public double getUploadSpeed() {
		return uploadSpeed;
	}

	public SSTResults setUploadSpeed(double uploadSpeed) {
		this.uploadSpeed = uploadSpeed;
		return this;
	}

	public int getPingDuration() {
		return pingDuration;
	}

	public SSTResults setPingDuration(int pingDuration) {
		this.pingDuration = pingDuration;
		return this;
	}

	public ConnectionInfoModel getDeviceInfo() {
		return deviceInfo;
	}

	public SSTResults setDeviceInfo(ConnectionInfoModel deviceInfo) {
		this.deviceInfo = deviceInfo;
		return this;
	}

	public MyLocation getServerLocation() {
		return serverLocation;
	}

	public SSTResults setServerLocation(MyLocation serverLocation) {
		this.serverLocation = serverLocation;
		return this;
	}
}
