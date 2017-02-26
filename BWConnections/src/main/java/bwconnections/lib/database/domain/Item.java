package bwconnections.lib.database.domain;

public class Item extends Entity {

	public interface Fields extends Entity.Fields{
		String PREF = "pref";
		String SUFF = "suff";
        String LEGENDARY = "legendary";
        String TYPE = "type";
        String BASE = "base";
        String QUALITY = "quality";
        String GRADE = "grade";
        String DISPLAY_NAME = "display_name";
    }
	
	public static String TABLE_NAME = "items";
	
	private Long pref;
	private Long suff;
	private boolean legendary;
	private Long type;
	private Long base;
	private Long quality;
	private Long grade;
	private String display_name;
	
	public Item(){		
	}
	
	public Item(Long id, Long pref, Long suff, boolean legendary, Long type, Long base, Long quality, Long grade, String display_name){
		this.id = id;
		this.pref = pref;
		this.suff = suff;
		this.legendary = legendary; 
		this.type = type;
		this.base = base;
		this.quality = quality;
		this.grade = grade;
		this.display_name = display_name;
	}
	
	public Item(Long pref, Long suff, boolean legendary, Long type, Long base, Long quality, Long grade, String display_name){
		this.pref = pref;
		this.suff = suff;
		this.legendary = legendary; 
		this.type = type;
		this.base = base;
		this.quality = quality;
		this.grade = grade;
		this.display_name = display_name;
	}
	
	@Override
	public String getInsertTablePlaces() {
		return " (?,?,?,?,?,?,?,?,?) ";
	}

	@Override
	public String getUpdateTablePlaces() {
		return Fields.ID + " = ?, " + Fields.PREF + " = ?, " + Fields.SUFF + " = ?, " + Fields.LEGENDARY + " = ?, " + Fields.TYPE + " = ?, " +
				Fields.BASE + " = ?, " + Fields.QUALITY + " = ?, " + Fields.GRADE + " = ?, " + Fields.DISPLAY_NAME + " = ? ";
	}

	public Long getPref() {
		return pref;
	}

	public void setPref(Long pref) {
		this.pref = pref;
	}

	public Long getSuff() {
		return suff;
	}

	public void setSuff(Long suff) {
		this.suff = suff;
	}

	public boolean isLegendary() {
		return legendary;
	}

	public void setLegendary(boolean legendary) {
		this.legendary = legendary;
	}

	public Long getQuality() {
		return quality;
	}

	public void setQuality(Long quality) {
		this.quality = quality;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getBase() {
		return base;
	}

	public void setBase(Long base) {
		this.base = base;
	}

	public Long getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade = grade;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

}
