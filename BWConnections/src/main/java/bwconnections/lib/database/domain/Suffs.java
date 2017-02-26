package bwconnections.lib.database.domain;


public class Suffs extends Entity {
	public interface Fields extends Entity.Fields{
		String VALUE = "value";
		String NAME = "name";
        String TYPE = "name_type";
    }
	
	public static String TABLE_NAME = "suffs";
	
	private Long value;
	private String name;
	private Long type;

	public Suffs() {
	}

	public Suffs(Long id, Long value, String name, Long type) {
		this.id = id;
		this.value = value;
		this.name = name;
		this.type = type;
	}

	public Suffs(Long value, String name, Long type) {
		this.value = value;
		this.name = name;
		this.type = type;
	}

	@Override
	public String getInsertTablePlaces() {
		return " (?,?,?,?) ";
	}

	@Override
	public String getUpdateTablePlaces() {
		return Fields.ID + " = ?, " + Fields.VALUE + " = ?, " + Fields.NAME + " = ?, "  + Fields.TYPE + " = ? ";
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

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

}
