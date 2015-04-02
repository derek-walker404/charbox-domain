package co.charbox.domain.model.mm;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.charbox.core.data.PersistentModel;
import co.charbox.domain.model.MyLocation;

public class SSTResults implements PersistentModel<SSTResults> {

	private String _id;
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

	@JsonProperty
	public String get_id() {
		return _id;
	}

	@JsonProperty
	public SSTResults set_id(String id) {
		this._id = id;
		return this;
	}

	@JsonProperty
	public String getDeviceId() {
		return deviceId;
	}

	@JsonProperty
	public SSTResults setDeviceId(String deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	@JsonProperty
	public String getDeviceKey() {
		return deviceKey;
	}

	@JsonProperty
	public SSTResults setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
		return this;
	}

	@JsonProperty
	public long getTestStartTime() {
		return testStartTime;
	}

	@JsonProperty
	public SSTResults setTestStartTime(long testStartTime) {
		this.testStartTime = testStartTime;
		return this;
	}

	@JsonProperty
	public int getDownloadSize() {
		return downloadSize;
	}

	@JsonProperty
	public SSTResults setDownloadSize(int downloadSize) {
		this.downloadSize = downloadSize;
		return this;
	}

	@JsonProperty
	public int getDownloadDuration() {
		return downloadDuration;
	}

	@JsonProperty
	public SSTResults setDownloadDuration(int downloadDuration) {
		this.downloadDuration = downloadDuration;
		return this;
	}

	@JsonProperty
	public double getDownloadSpeed() {
		return downloadSpeed;
	}

	@JsonProperty
	public SSTResults setDownloadSpeed(double downloadSpeed) {
		this.downloadSpeed = downloadSpeed;
		return this;
	}

	@JsonProperty
	public int getUploadSize() {
		return uploadSize;
	}

	@JsonProperty
	public SSTResults setUploadSize(int uploadSize) {
		this.uploadSize = uploadSize;
		return this;
	}

	@JsonProperty
	public int getUploadDuration() {
		return uploadDuration;
	}

	@JsonProperty
	public SSTResults setUploadDuration(int uploadDuration) {
		this.uploadDuration = uploadDuration;
		return this;
	}

	@JsonProperty
	public double getUploadSpeed() {
		return uploadSpeed;
	}

	@JsonProperty
	public SSTResults setUploadSpeed(double uploadSpeed) {
		this.uploadSpeed = uploadSpeed;
		return this;
	}

	@JsonProperty
	public int getPingDuration() {
		return pingDuration;
	}

	@JsonProperty
	public SSTResults setPingDuration(int pingDuration) {
		this.pingDuration = pingDuration;
		return this;
	}

	@JsonProperty
	public ConnectionInfoModel getDeviceInfo() {
		return deviceInfo;
	}

	@JsonProperty
	public SSTResults setDeviceInfo(ConnectionInfoModel deviceInfo) {
		this.deviceInfo = deviceInfo;
		return this;
	}

	@JsonProperty
	public MyLocation getServerLocation() {
		return serverLocation;
	}

	@JsonProperty
	public SSTResults setServerLocation(MyLocation serverLocation) {
		this.serverLocation = serverLocation;
		return this;
	}
}
