package bwconnections.lib.database.domain;

public abstract class Entity {
	
	public interface Fields {
        String ID = "id";
    }

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public abstract String getInsertTablePlaces();
     
    public abstract String getUpdateTablePlaces();
}
