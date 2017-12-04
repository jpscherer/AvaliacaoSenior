package dataLayer;

import java.util.Map;
import java.lang.reflect.Field;

public class City implements Entity {

	private Integer ibge_id;
	private String uf;
	private String name;
	private Boolean capital;
	private long lon;
	private long lat;
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

	public long getLon() {
		return lon;
	}

	public void setLon(long lon) {
		this.lon = lon;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public long getLat() {
		return lat;
	}

	public void setLat(long lat) {
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
	public City getFromLine(String pLine, Map<String, Integer> pHeadersIndex) {
		try {
			String[] columns = pLine.split(CSVDocumentModelCity.COMMA_DELIMITER);
			for (Field field : this.getClass().getDeclaredFields()) {

				int index = pHeadersIndex.get(field.getName());

				if (field.getType().equals(String.class))
					field.set(this, (String) columns[index]);
				else if (field.getType().equals(Integer.class))
					field.set(this, Integer.getInteger(columns[index]));
				else if (field.getType().equals(Boolean.class))
					field.set(this, Boolean.getBoolean(columns[index]));

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return this;
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
		StringBuilder sb = new StringBuilder();

		/*
		 * fileWriter.append(String.valueOf(city.getName()));
		 * fileWriter.append(CSVDocumentModel.COMMA_DELIMITER);
		 * fileWriter.append(record.getMesoregion());
		 * fileWriter.append(CSVDocumentModel.NEW_LINE_SEPARATOR);
		 */

		return sb.toString();
	}
}