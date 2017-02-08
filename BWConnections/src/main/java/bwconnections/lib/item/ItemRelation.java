package bwconnections.lib.item;

public class ItemRelation {
	
	private long id;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
