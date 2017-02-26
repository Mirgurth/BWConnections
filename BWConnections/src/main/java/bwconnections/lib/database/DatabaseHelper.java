package bwconnections.lib.database;

import bwconnections.lib.database.daos.ItemDao;
import bwconnections.lib.database.daos.ItemRelationDao;

public class DatabaseHelper {
	private static final String DATABASE_NAME = "bwConnections.db";

    private static DatabaseHelper instance;
    private String databaseFile = "res/bwConnections.db";

    public static DatabaseHelper getInstance() {
        if (instance == null) {
            instance = new DatabaseHelper();
        }
        return instance;
    }
    
    public ItemDao getItemDao(){
    	return new ItemDao();
    }
    
    public ItemRelationDao ItemRelationDao(){
    	return new ItemRelationDao();
    }
}
