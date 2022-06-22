package com.kulu.domain;


public class 產品庫存MS {

	private String 異動時間;
	private String 貨品代號;
	private String 倉庫;
	private String 庫位名稱;
	private Integer 現有存量;
	private String 來源程式或目加總目的;
	
	
	public 產品庫存MS() {
//		super();
	}
	
	public 產品庫存MS(String 異動時間, String 貨品代號, String 倉庫, String 庫位名稱, Integer 現有存量, String 來源程式或目加總目的) {
//		super();
		this.異動時間 = 異動時間;
		this.貨品代號 = 貨品代號;
		this.倉庫 = 倉庫;
		this.庫位名稱 = 庫位名稱;
		this.現有存量 = 現有存量;
		this.來源程式或目加總目的 = 來源程式或目加總目的;
	}

	public String get異動時間() {
		return 異動時間;
	}
	public void set異動時間(String 異動時間) {
		this.異動時間 = 異動時間;
	}
	public String get貨品代號() {
		return 貨品代號;
	}
	public void set貨品代號(String 貨品代號) {
		this.貨品代號 = 貨品代號;
	}
	public String get倉庫() {
		return 倉庫;
	}
	public void set倉庫(String 倉庫) {
		this.倉庫 = 倉庫;
	}
	public String get庫位名稱() {
		return 庫位名稱;
	}
	public void set庫位名稱(String 庫位名稱) {
		this.庫位名稱 = 庫位名稱;
	}
	public Integer get現有存量() {
		return 現有存量;
	}
	public void set現有存量(Integer 現有存量) {
		this.現有存量 = 現有存量;
	}
	public String get來源程式或目加總目的() {
		return 來源程式或目加總目的;
	}
	public void set來源程式或目加總目的(String 來源程式或目加總目的) {
		this.來源程式或目加總目的 = 來源程式或目加總目的;
	}

	@Override
	public String toString() {
		return "產品庫存MS [異動時間=" + 異動時間 + ", 貨品代號=" + 貨品代號 + ", 倉庫=" + 倉庫 + ", 庫位名稱=" + 庫位名稱 + ", 現有存量=" + 現有存量
				+ ", 來源程式或目加總目的=" + 來源程式或目加總目的 + "]";
	}
}
