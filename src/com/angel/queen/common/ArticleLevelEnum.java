package com.angel.queen.common;

/**
 * 订单状态枚举
 * @author Jihann
 */
public enum ArticleLevelEnum {
	/**
	 * 火贴
	 */
	ARTICLE_LEVEL_HOT(101,"火"),
	/**
	 * 精贴
	 */
	ARTICLE_LEVEL_FINE(102,"精"),
	/**
	 * 潜力股
	 */
	ARTICLE_LEVEL_POTENTIAL(103,"潜力股");

	
	private int key;
	private String value;
	
	private ArticleLevelEnum(int key,String value){
		this.key=key;
		this.value=value;
	}
	public static String getValue(int key) {
		switch (key) {
			case 101:
				return "火";
			case 102:
				return "精";
			case 103:
				return "潜力股";
			default:
				return null;
		}
	}
	public int getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	
}
