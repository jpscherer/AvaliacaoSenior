package dataLayer;

import java.util.Map;
import java.lang.reflect.Field;

public class City implements Entity {

	private Integer ibge_id;
	private String uf;
	private String name;
	private Boolean capital;
	private Double lon;
	private Double lat;
	private String no_accents;
	private String alternative_names;
	private String microregion;
	private String mesoregion;

	public Integer getIbge_id() {
		return ibge_id;
	}

	public void setIbge_id(Integer ibge_id) {
		this.ibge_id = ibge_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getCapital() {
		return capital;
	}

	public void setCapital(Boolean capital) {
		this.capital = capital;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public String getNo_accents() {
		return no_accents;
	}

	public void setNo_accents(String no_accents) {
		this.no_accents = no_accents;
	}

	public String getAlternative_names() {
		return alternative_names;
	}

	public void setAlternative_names(String alternative_names) {
		this.alternative_names = alternative_names;
	}

	public String getMicroregion() {
		return microregion;
	}

	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}

	public String getMesoregion() {
		return mesoregion;
	}

	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}
	
	@Override
	public String toString() {
		
		return String.format("%s - %s", getIbge_id(), getName());
	}

	@Override
	public City getFromLine(String pLine, Map<String, Integer> pHeadersIndex) {
		City returner = new City();
		try {
			String[] columns = pLine.split(CSVDocumentModelCity.COMMA_DELIMITER);
			for (Field field : this.getClass().getDeclaredFields()) {

				int index = pHeadersIndex.get(field.getName());

				if (field.getType().equals(String.class))
					field.set(returner, (String) columns[index]);
				else if (field.getType().equals(Integer.class))
					field.set(returner, Integer.parseInt(columns[index]));
				else if (field.getType().equals(Double.class))
					field.set(returner, Double.parseDouble(columns[index]));
				else if (field.getType().equals(Boolean.class))
					field.set(returner, Boolean.getBoolean(columns[index]));

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return returner;
	}

	@Override
	public String getFilePath() {
		return CSVDocumentModelCity.FILE_PATH;
	}

	@Override
	public String getFileHeader() {
		return CSVDocumentModelCity.FILE_HEADER;
	}

	@Override
	public String getToLine(Object pRecord) {
		City record = (City)pRecord;
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.valueOf(record.getIbge_id()));
		sb.append(CSVDocumentModel.COMMA_DELIMITER);
		
		sb.append(String.valueOf(record.getUf()));
		sb.append(CSVDocumentModel.COMMA_DELIMITER);
		
		sb.append(String.valueOf(record.getName()));
		sb.append(CSVDocumentModel.COMMA_DELIMITER);
		
		sb.append(String.valueOf(record.getCapital()));
		sb.append(CSVDocumentModel.COMMA_DELIMITER);
		
		sb.append(String.valueOf(record.getLon()));
		sb.append(CSVDocumentModel.COMMA_DELIMITER);
		
		sb.append(String.valueOf(record.getLat()));
		sb.append(CSVDocumentModel.COMMA_DELIMITER);
		
		sb.append(String.valueOf(record.getNo_accents()));
		sb.append(CSVDocumentModel.COMMA_DELIMITER);
		
		sb.append(String.valueOf(record.getAlternative_names()));
		sb.append(CSVDocumentModel.COMMA_DELIMITER);
		
		sb.append(String.valueOf(record.getMicroregion()));
		sb.append(CSVDocumentModel.COMMA_DELIMITER);
		
		sb.append(String.valueOf(record.getMesoregion()));		
		sb.append(CSVDocumentModel.NEW_LINE_SEPARATOR);
		
		return sb.toString();
	}
}
