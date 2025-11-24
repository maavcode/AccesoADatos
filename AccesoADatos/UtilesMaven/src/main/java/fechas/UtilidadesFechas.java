package fechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UtilidadesFechas {

	/**
	 * Transforma un String en un java.util.Date.
	 * @param fecha La fecha con formato: dd/MM/yyyy.
	 * @return La fecha parseada a un objeto java.util.Date.
	 */
	public static java.util.Date parseDate(String fecha) {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaParseada = null;
		try {
			fechaParseada = sf.parse(fecha);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return fechaParseada;
	}
	
	/**
	 * Transforma un String en un java.time.LocalDateTime.
	 * @param fecha La fecha con formato: yyyy-MM-dd HH:mm:ss.
	 * @return La fecha parseada a un objeto java.time.LocalDateTime.
	 */
	public static java.time.LocalDateTime parseLocalDateTime(String fecha){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(fecha, formatter);
		return dateTime;
	}
	
	/**
	 * Transoforma un java.util.Date en un java.sql.Date, normalmente para ser guardado en una BD.
	 * @param fecha Un objeto java.util.Date.
	 * @return Un objeto java.sql.Date
	 */
	public static java.sql.Date parseSqlDate(Date fecha){
		return new java.sql.Date(fecha.getTime());
	}
	
	/**
	 * Llama al método estático "valueOf" de java.sql.Timestamp.
	 * @param fecha La Fecha java.time.LocalDateTime.
	 * @return Un objeto java.sql.Timestamp con la fecha que contenía el java.time.LocalDateTime.
	 */
	public static java.sql.Timestamp parseSqlTimestamp(java.time.LocalDateTime fecha){
		return java.sql.Timestamp.valueOf(fecha);
	}
	
	/**
	 * Obtiene la fecha actual haciendo uso del método estático "from" de java.util.Date, pasándole
	 * por parámetro un objeto java.time.Instant obtenido del método estático "now" de java.time.Instant.
	 * @return La fecha actual del equipo en un objeto java.util.date.
	 */
	public static java.util.Date getDateActual(){
		return Date.from(Instant.now());
	}
	
	/**
	 * Obtiene la fecha actual haciendo uso del método estático "from" de java.util.Date, pasándole
	 * por parámetro un objeto java.time.Instant obtenido del método estático "now" de java.time.Instant.
	 * 
	 * Por último el java.util.Date obtenido se pasa al método "parseSqlDate" de esta clase.
	 * @return La fecha actual del equipo en un objeto java.sql.date.
	 */
	public static java.sql.Date getSqlDateActual(){
		return parseSqlDate(getDateActual());
	}
}
