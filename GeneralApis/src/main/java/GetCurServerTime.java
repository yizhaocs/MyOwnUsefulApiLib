package main.java;

public class GetCurServerTime {
	protected static String getCurServerTime() {
		long TIME = System.currentTimeMillis();
		String TIME_STRING = String.valueOf(TIME);
		String TS = TIME_STRING.substring(0, TIME_STRING.length() - 3);
		return TS;
	}
}
