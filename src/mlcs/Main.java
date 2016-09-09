package mlcs;

import java.util.List;

import utils.STUtils;


public class Main {
	public static void main(String[] args) {
		String file="sequence";
		List<SucTable> suc_table = STUtils.buildSTfromFile(file);
		for (SucTable sucTable : suc_table) {
			System.out.println(sucTable);
		}
	}
}
