package bwconnections.lib.database.domain;

import bwconnections.lib.database.domain.Grade.Fields;

public class Type extends Entity {

	public interface Fields extends Entity.Fields{
		String VALUE = "value";
    }
	
	public static String TABLE_NAME = "types";
	
	private Long value;

	public Type() {
	}

	public Type(Long id, Long value) {
		this.id = id;
		this.value = value;
	}

	public Type(Long value) {
		this.value = value;
	}

	@Override
	public String getInsertTablePlaces() {
		return " (?,?) ";
	}

	@Override
	public String getUpdateTablePlaces() {
		return Fields.ID + " = ?, " + Fields.VALUE + " = ? ";
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

}
