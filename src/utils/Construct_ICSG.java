package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.google.common.collect.HashBiMap;

import mlcs.PointNode;
import mlcs.SucTable;

public class Construct_ICSG {
	
   private Construct_ICSG(){
		
	}
   public static void ConstructIgsg(List<SucTable> suc_table) {
	   
	   Queue<PointNode> qpoint=new LinkedList<PointNode>();
	   int[] p=new int[suc_table.size()];
	   int indexOfPoint=0;
	   PointNode point=new PointNode();
	   point.setPoint(p);
	   qpoint.offer(point);
//	   HashBiMap<Integer,PointNode> DatabaseMetaData = HashBiMap.create();
	   
}
   public static void ProduceSuc(PointNode point,List<SucTable> suc_table,Queue<PointNode> qpoint){
	   int[] pold=new int[suc_table.size()];
	   int[] pnew=new int[suc_table.size()];
	   PointNode pn=new PointNode();
	   pold=point.getPoint();
	   for(int i=0;i<4;i++){
		   int flag=1;
		   
		   for(int j=0;j<suc_table.size();j++){
			   int m=suc_table.get(j).getLength()+1;
			   int[][] table=new int[4][m];
			   table=suc_table.get(j).getTable();
			   pnew[j]=table[i][pold[j]];
			   if(pnew[j]==0){
				  flag=0;
				  break;
			   }
		   }
		   
		   if(flag==1){
		    pn.setPoint(pnew);
		    qpoint.offer(pn);
		   }
		   
		 }

   }

}
