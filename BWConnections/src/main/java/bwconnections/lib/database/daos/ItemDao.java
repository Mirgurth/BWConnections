package bwconnections.lib.database.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import bwconnections.lib.database.domain.Item;

public class ItemDao extends BaseDao<Item> {

	@Override
	protected String getTableName() {
		return Item.TABLE_NAME;
	}

	@Override
	protected Item mapFromResultSet(ResultSet set) {
		Item item = null;
		try{
			Long id = set.getLong(Item.Fields.ID);
			Long pref = set.getLong(Item.Fields.PREF);
			Long suff = set.getLong(Item.Fields.SUFF);
			boolean legendary = set.getBoolean(Item.Fields.LEGENDARY);
			Long type = set.getLong(Item.Fields.TYPE);
			Long base = set.getLong(Item.Fields.BASE);
			Long quality = set.getLong(Item.Fields.QUALITY);
			Long grade = set.getLong(Item.Fields.GRADE);
			String display_name = set.getString(Item.Fields.DISPLAY_NAME);
			item = new Item( id, pref, suff, legendary, type, base, quality, grade, display_name );
		} catch (SQLException e){
			e.printStackTrace();
		}
		return item;
	}

	@Override
	protected PreparedStatement mapToInsertStatement(PreparedStatement statement, Item entity) {
		try{
			statement.setNull(1, Types.INTEGER);
			statement.setLong(2, entity.getPref());
			statement.setLong(3, entity.getSuff());
			statement.setBoolean(4, entity.isLegendary());
			statement.setLong(5, entity.getType());
			statement.setLong(6, entity.getBase());
			statement.setLong(7, entity.getQuality());
			statement.setLong(8, entity.getGrade());
			statement.setString(9, entity.getDisplay_name());
		} catch (SQLException e){
			e.printStackTrace();
		}
		return statement;
	}

	@Override
	protected PreparedStatement mapToUpdateStatement(PreparedStatement statement, Item entity) {
		try{
			statement.setLong(1, entity.getId());
			statement.setLong(2, entity.getPref());
			statement.setLong(3, entity.getSuff());
			statement.setBoolean(4, entity.isLegendary());
			statement.setLong(5, entity.getType());
			statement.setLong(6, entity.getBase());
			statement.setLong(7, entity.getQuality());
			statement.setLong(8, entity.getGrade());
			statement.setString(9, entity.getDisplay_name());
		} catch (SQLException e){
			e.printStackTrace();
		}
		return statement;
	}

}
