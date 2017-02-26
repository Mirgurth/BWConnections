package bwconnections.lib.database.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.sqlite.SQLiteDataSource;

import bwconnections.lib.database.DatabaseHelper;
import bwconnections.lib.database.domain.Entity;

public abstract class BaseDao<T extends Entity> {
	protected DatabaseHelper dbhelper;
    private SQLiteDataSource database;

    public BaseDao(){
        dbhelper = new DatabaseHelper();
        database = new SQLiteDataSource();
        database.setUrl("jdbc:sqlite::resource:bwConnections.db");
    }

    public T getById(long id) {
        String query = "SELECT * FROM " + getTableName() + " WHERE id = " + id;
        ResultSet set;
        T result = null;
        Statement statement;
        try {
            statement = database.getConnection().createStatement();
            set = statement.executeQuery(query);
            result = mapFromResultSet(set);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<T> getAllFromTable(String where, String arg){
        String query = "SELECT * FROM " + getTableName() + "WHERE " + where + " = " + arg;
        ArrayList<T> result = new ArrayList<>();
        ResultSet set = null;
        Statement statement = null;
        try {
            statement = database.getConnection().createStatement();
            set = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (set.next()){
                result.add(mapFromResultSet(set));
            }
            if(statement!=null)
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<T> getAllFromTable(){
        String query = "SELECT * FROM " + getTableName();
        Statement statement = null;
        ArrayList<T> result = new ArrayList<>();
        ResultSet set = null;
        try {
            statement = database.getConnection().createStatement();
            set = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (set.next()){
                result.add(mapFromResultSet(set));
            }
            if (statement!=null){
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void insert(T entity){
        String query = "INSERT INTO " + getTableName()  + " VALUES " + entity.getInsertTablePlaces();
        PreparedStatement statement;
        try {
            statement = database.getConnection().prepareStatement(query);
            statement = mapToInsertStatement(statement, entity);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAll(ArrayList<T> entities){
        for(T entity : entities){
            insert(entity);
        }
    }

    public void update(T entity){
        String query = "UPDATE " + getTableName() + " SET " + entity.getUpdateTablePlaces() + " WHERE id = " + entity.getId();
        PreparedStatement statement;
        try {
            statement = database.getConnection().prepareStatement(query);
            statement = mapToUpdateStatement(statement, entity);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOrUpdate(T entity){
        if(entity.getId() != null){
            update(entity);
        }else{
            insert(entity);
        }
    }

    public void insertOrUpdate(ArrayList<T> entities){
        for(T entity : entities){
            insertOrUpdate(entity);
        }
    }

    public void delete(T entity){
        String query = "DELETE FROM " + getTableName() + " WHERE id = " + entity.getId();
        Statement statement;
        try {
            statement = database.getConnection().createStatement();
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(ArrayList<T> entities){
        for(T entity : entities){
            delete(entity);
        }
    }

    public void delete(String where, String arg){
        String query = "DELETE FROM " + getTableName() + "WHERE " + where + " = " + arg;
        Statement statement;
        try {
            statement = database.getConnection().createStatement();
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract String getTableName();

    protected abstract T mapFromResultSet(ResultSet set);

    protected abstract PreparedStatement mapToInsertStatement(PreparedStatement statement, T entity);

    protected abstract PreparedStatement mapToUpdateStatement(PreparedStatement statement, T entity);
}
