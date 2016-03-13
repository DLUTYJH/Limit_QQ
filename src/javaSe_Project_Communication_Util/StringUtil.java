package javaSe_Project_Communication_Util;

/**
 * 方法类: 字符串的处理
 * 
 * @author answer
 *
 */

public interface StringUtil {

	/**
	 * 判断字符串是否为空,如果为空返回true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str.isEmpty();
	}

	/**
	 * 判断字符串是否是数字,如果是全部是数字,返回true
	 * 
	 * @param str
	 * @return
	 */

	public static boolean isNumber(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断端口号是否在规定范围内:1024~65535 在这范围内返回: ture ;
	 * 
	 * @param port
	 * @return
	 */

	public static boolean isPortCrrect(String port) {

		int temp = Integer.parseInt(port);
		if (temp < 1024 || temp > 65535) {
			return false;
		}
		return true;
	}

}
