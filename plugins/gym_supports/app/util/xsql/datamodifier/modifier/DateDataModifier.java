package util.xsql.datamodifier.modifier;

import util.xsql.datamodifier.DataModifier;
import util.xsql.datamodifier.DefaultUtils;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author badqiu
 */
public class DateDataModifier implements DataModifier {
	
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private String dateFormat = DEFAULT_DATE_FORMAT;
	
	public DateDataModifier(){}
	
	public DateDataModifier(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	public Object modify(Object value, String modifierArgument)throws Exception {
		if(value == null) return null;
		if(value instanceof Date) return value;
		DateFormat df = DefaultUtils.defaultDateFormat(modifierArgument, dateFormat);
		return df.parse(value.toString());
	}
}
