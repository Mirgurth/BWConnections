package bwconnections.lib.database.domain;


public class Grade extends Entity {
	public interface Fields extends Entity.Fields{
		String VALUE = "value";
		String NAME = "name";
        String NAME_TYPE = "name_type";
    }
	
	public static String TABLE_NAME = "base";
	
	private Long value;
	private String name;
	private Long name_type;

	public Grade() {
	}

	public Grade(Long id, Long value, String name, Long name_type) {
		this.id = id;
		this.value = value;
		this.name = name;
		this.name_type = name_type;
	}

	public Grade(Long value, String name, Long name_type) {
		this.value = value;
		this.name = name;
		this.name_type = name_type;
	}

	@Override
	public String getInsertTablePlaces() {
		return " (?,?,?,?) ";
	}

	@Override
	public String getUpdateTablePlaces() {
		return Fields.ID + " = ?, " + Fields.VALUE + " = ?, " + Fields.NAME + " = ?, "  + Fields.NAME_TYPE + " = ? ";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Long getName_type() {
		return name_type;
	}

	public void setName_type(Long name_type) {
		this.name_type = name_type;
	}

}
