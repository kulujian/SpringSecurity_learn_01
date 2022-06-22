package com.kulu.domain;

public class 當日庫存 {

	private String 品號;
	private String 品名;
	private String 庫存日期;
	private String 庫別;
	private String 庫別名稱;
	private Integer 前日庫存;
	private Integer 銷貨數量;
	private Integer 銷退數量;
	private Integer 轉出數量;
	private Integer 轉入數量;
	private Integer 暫出數量;
	private Integer 當日庫存;

	
	public 當日庫存() {
//		super();
	}
	
	public 當日庫存(String 品號, String 品名, String 庫存日期, String 庫別, String 庫別名稱, Integer 前日庫存, Integer 銷貨數量, Integer 銷退數量,
			Integer 轉出數量, Integer 轉入數量, Integer 暫出數量, Integer 當日庫存) {
//		super();
		this.品號 = 品號;
		this.品名 = 品名;
		this.庫存日期 = 庫存日期;
		this.庫別 = 庫別;
		this.庫別名稱 = 庫別名稱;
		this.前日庫存 = 前日庫存;
		this.銷貨數量 = 銷貨數量;
		this.銷退數量 = 銷退數量;
		this.轉出數量 = 轉出數量;
		this.轉入數量 = 轉入數量;
		this.暫出數量 = 暫出數量;
		this.當日庫存 = 當日庫存;
	}


	public String get品號() {
		return 品號;
	}
	public void set品號(String 品號) {
		this.品號 = 品號;
	}
	public String get品名() {
		return 品名;
	}
	public void set品名(String 品名) {
		this.品名 = 品名;
	}
	public String get庫存日期() {
		return 庫存日期;
	}
	public void set庫存日期(String 庫存日期) {
		this.庫存日期 = 庫存日期;
	}
	public String get庫別() {
		return 庫別;
	}
	public void set庫別(String 庫別) {
		this.庫別 = 庫別;
	}
	public String get庫別名稱() {
		return 庫別名稱;
	}
	public void set庫別名稱(String 庫別名稱) {
		this.庫別名稱 = 庫別名稱;
	}
	public Integer get前日庫存() {
		return 前日庫存;
	}
	public void set前日庫存(Integer 前日庫存) {
		this.前日庫存 = 前日庫存;
	}
	public Integer get銷貨數量() {
		return 銷貨數量;
	}
	public void set銷貨數量(Integer 銷貨數量) {
		this.銷貨數量 = 銷貨數量;
	}
	public Integer get銷退數量() {
		return 銷退數量;
	}
	public void set銷退數量(Integer 銷退數量) {
		this.銷退數量 = 銷退數量;
	}
	public Integer get轉出數量() {
		return 轉出數量;
	}
	public void set轉出數量(Integer 轉出數量) {
		this.轉出數量 = 轉出數量;
	}
	public Integer get轉入數量() {
		return 轉入數量;
	}
	public void set轉入數量(Integer 轉入數量) {
		this.轉入數量 = 轉入數量;
	}
	public Integer get暫出數量() {
		return 暫出數量;
	}
	public void set暫出數量(Integer 暫出數量) {
		this.暫出數量 = 暫出數量;
	}
	public Integer get當日庫存() {
		return 當日庫存;
	}
	public void set當日庫存(Integer 當日庫存) {
		this.當日庫存 = 當日庫存;
	}

	
	@Override
	public String toString() {
		return "當日庫存 [品號=" + 品號 + ", 品名=" + 品名 + ", 庫存日期=" + 庫存日期 + ", 庫別=" + 庫別 + ", 庫別名稱=" + 庫別名稱 + ", 前日庫存=" + 前日庫存
				+ ", 銷貨數量=" + 銷貨數量 + ", 銷退數量=" + 銷退數量 + ", 轉出數量=" + 轉出數量 + ", 轉入數量=" + 轉入數量 + ", 暫出數量=" + 暫出數量
				+ ", 當日庫存=" + 當日庫存 + "]";
	}
}
