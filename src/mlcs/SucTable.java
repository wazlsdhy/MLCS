package mlcs;

public class SucTable {
	int length;
	String sequence;
	int table[][];
	
	
	public SucTable() {
		super();
	}
	public SucTable(int length, String sequence, int[][] table) {
		super();
		this.length = length;
		this.sequence = sequence;
		this.table = table;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public int[][] getTable() {
		return table;
	}
	public void setTable(int[][] table) {
		this.table = table;
	}
	@Override
	public String toString() {
		
		return "SucTable [length=" + length + ", sequence=" + sequence
				+ "\ntable=\n" + printTable() + "]";
	}
	
	private String printTable(){
		StringBuffer str_table = new StringBuffer();
		if (table !=null){
			int row=this.table.length;
			if (row >=1){	
				int col = this.table[0].length;
				for (int i =0;i<row;i++){
					for (int j =0; j < col;++j)
						str_table.append(table[i][j]);
					str_table.append('\n');	
				}
			}
			
		}
		return str_table.toString();
		
	}
	
}
