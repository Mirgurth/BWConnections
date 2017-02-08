package lib;

public class Item {

	private long id;
	private int pref;
	private int suff;
	private boolean legendary;
	private int type;
	private int base;
	private int quality;
	private int grade;
	private String displayName;
	
	public Item(){		
	}
	
	public Item(int pref, int suff, boolean isLegendary, int type, int base, int quality, int grade, String displayName){
		this.pref = pref;
		this.suff = suff;
		this.legendary = isLegendary;
		this.type = type;
		this.base = base;
		this.quality = quality;
		this.grade = grade;
		this.displayName = displayName;	
	}
	
	public Item(long id, int pref, int suff, boolean isLegendary, int type, int base, int quality, int grade, String displayName){
		this.id = id;
		this.pref = pref;
		this.suff = suff;
		this.legendary = isLegendary;
		this.type = type;
		this.base = base;
		this.quality = quality;
		this.grade = grade;
		this.displayName = displayName;			
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isLegendary() {
		return legendary;
	}

	public void setLegendary(boolean legendary) {
		this.legendary = legendary;
	}

	public int getPref() {
		return pref;
	}

	public void setPref(int pref) {
		this.pref = pref;
	}

	public int getSuff() {
		return suff;
	}

	public void setSuff(int suff) {
		this.suff = suff;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
