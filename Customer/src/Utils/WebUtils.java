package Utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class WebUtils {
	//使用泛型，将用户请求数据封装到一个实体类中
	public static <T> T  requestToBean(HttpServletRequest request,Class<T> clas){
			try {
				T bean = clas.newInstance();
				Map map =request.getParameterMap();
				//注册一个日期转换器，注意导包的时候不要导入sql。Date包
				ConvertUtils.register(new Converter() {
					
					@Override
					public Object convert(Class type, Object value) {
					 if(value==null){
						 return null;
					 }
					 String str = (String)value;
					 if(str.trim().equals("")){
						 return null;
					 }
					 try {
						 SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
						  return sd.parse(str);
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
				},Date.class);
				//ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.populate(bean, map);
				return bean;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} 
		
	} 
	
	//使用UUID算法，生成一个唯一的ID
	public static String getID(){
		return UUID.randomUUID().toString();
	}
}
