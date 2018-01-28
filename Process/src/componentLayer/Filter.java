package componentLayer;

public class Filter {
	private String column;
	private Object value;
	
	public String getColumn() {
		return column;
	}
	public Object getValue() {
		return value;
	}
	
	public Filter(String pColumn, String pValue) {
		this.column = pColumn;
		this.value = pValue;
	}
	
	public Filter(String pColumn, Integer pValue) {
		this.column = pColumn;
		this.value = pValue;
	}
	
	public Filter(String pColumn, Boolean pValue) {
		this.column = pColumn;
		this.value = pValue;
	}
}
