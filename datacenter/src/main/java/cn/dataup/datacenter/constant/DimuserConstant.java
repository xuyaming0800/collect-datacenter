package cn.dataup.datacenter.constant;

/**
 * @Description: 常量
 * @author 刘旭升
 * @date 2015年7月8日 下午2:37:47 
 * @version V1.0 
 */
public class DimuserConstant {
	
	/**
	 * 查询注册用户的周期（单位为天）
	 */
	public static final Integer dateAmount = 30;

	public static String getName(Integer key) {
		if (key == dateAmount)
			return "查询的天数";
		return null;
	}

}
