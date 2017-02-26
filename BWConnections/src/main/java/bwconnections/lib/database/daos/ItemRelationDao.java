package bwconnections.lib.database.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import bwconnections.lib.database.domain.Entity;
import bwconnections.lib.database.domain.Item;
import bwconnections.lib.database.domain.ItemRelation;

public class ItemRelationDao extends BaseDao<ItemRelation> {

	@Override
	protected String getTableName() {
		return ItemRelation.TABLE_NAME;
	}

	@Override
	protected ItemRelation mapFromResultSet(ResultSet set) {
		ItemRelation item = null;
		try{
			Long id = set.getLong(Item.Fields.ID);
			Long child = set.getLong(ItemRelation.Fields.CHILD);
			Long parent_left = set.getLong(ItemRelation.Fields.PARENT_LEFT);
			Long parent_right = set.getLong(ItemRelation.Fields.PARENT_RIGHT);
			item = new ItemRelation( id, child, parent_left, parent_right);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return item;
	}

	@Override
	protected PreparedStatement mapToInsertStatement(PreparedStatement statement, ItemRelation entity) {
		try{
			statement.setNull(1, Types.INTEGER);
			statement.setLong(2, entity.getChild());
			statement.setLong(3, entity.getParentLeft());
			statement.setLong(4, entity.getParentRight());
		} catch (SQLException e){
			e.printStackTrace();
		}
		return statement;
	}

	@Override
	protected PreparedStatement mapToUpdateStatement(PreparedStatement statement, ItemRelation entity) {
		try{
			statement.setLong(1, entity.getId());
			statement.setLong(2, entity.getChild());
			statement.setLong(3, entity.getParentLeft());
			statement.setLong(4, entity.getParentRight());
		} catch (SQLException e){
			e.printStackTrace();
		}
		return statement;
	}

}
