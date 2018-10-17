package com.team.titans.tpk_learning_app;

public class DatabaseSyncHelper {
	private DatabaseHelper helper = null;

    public DatabaseSyncHelper(DatabaseHelper helper) {
		this.helper = helper;
	}

	public void updateDatabase() {
        this.helper.populateWords();
    }
}
