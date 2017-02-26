package bwconnections.lib.database.domain;

public class ItemRelation extends Entity {
	
	public interface Fields extends Entity.Fields{
		String CHILD = "child";
		String PARENT_LEFT = "parent_left_id";
        String PARENT_RIGHT = "parent_right_id";
    }
	
	public static String TABLE_NAME = "items_relations";
	
	private long child;
	private long parentLeft;
	private long parentRight;
	
	public ItemRelation() {
	}
	
	public ItemRelation(long child, long parentLeft, long parentRight) {
		this.child = child;
		this.parentLeft = parentLeft;
		this.parentRight = parentRight;
	}	
	
	public ItemRelation(long id, long child, long parentLeft, long parentRight) {
		this.id = id;
		this.child = child;
		this.parentLeft = parentLeft;
		this.parentRight = parentRight;
	}	
	
	public long getChild() {
		return child;
	}
	public void setChild(long child) {
		this.child = child;
	}
	public long getParentLeft() {
		return parentLeft;
	}
	public void setParentLeft(long parentLeft) {
		this.parentLeft = parentLeft;
	}
	public long getParentRight() {
		return parentRight;
	}
	public void setParentRight(long parentRight) {
		this.parentRight = parentRight;
	}

	@Override
	public String getInsertTablePlaces() {
		return " (?,?,?,?) ";
	}

	@Override
	public String getUpdateTablePlaces() {
		return Fields.ID + " = ?, " + Fields.CHILD + " = ?, " + Fields.PARENT_LEFT + " = ?, "  + Fields.PARENT_RIGHT + " = ? ";
	}
}
