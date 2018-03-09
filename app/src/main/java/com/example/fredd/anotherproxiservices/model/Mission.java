package com.example.fredd.anotherproxiservices.model;

/**
 * Created by Fredd on 08/03/2018.
 */

public class Mission {
	private int missionID;
	private int missionStatus;
	private String missionFriendlyName;

	public int getMissionID() {
		return missionID;
	}

	public void setMissionID(int missionID) {
		this.missionID = missionID;
	}

	public int getMissionStatus() {
		return missionStatus;
	}

	public void setMissionStatus(int missionStatus) {
		this.missionStatus = missionStatus;
	}

	public String getMissionFriendlyName() {
		return missionFriendlyName;
	}

	public void setMissionFriendlyName(String missionFriendlyName) {
		this.missionFriendlyName = missionFriendlyName;
	}
}
