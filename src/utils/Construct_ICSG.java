package utils;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.google.common.collect.BiMap;


import com.google.common.collect.HashBiMap;

import javax.management.Query;





import mlcs.PointNode;
import mlcs.SucTable;

public class Construct_ICSG {
	
   private Construct_ICSG(){
		
	}
   
   //�������еĺ�̽ڵ�
   public static HashBiMap<Integer, PointNode> ConstructIgsg(List<SucTable> suc_table) {
	   
	   Queue<PointNode> qpoint=new LinkedList<PointNode>();   //���ɶ��� qpoint
	   int[] p=new int[suc_table.size()];           
	   int indexOfPoint=0;
	   PointNode point=new PointNode();         //���ɵ� point
	   point.setPoint(p);
	   point.setID(0);
	   qpoint.offer(point);
	   HashBiMap<Integer,PointNode> DM=HashBiMap.create();   //����˫��hash��
	   BiMap<PointNode, Integer> inverse = DM.inverse();
	   DM.forcePut(indexOfPoint, point);      //�ѳ�ʼ��������
	   indexOfPoint++;                 //��ż�1
	   while(!qpoint.isEmpty()){      //���зǿ�
		   PointNode q=qpoint.poll();   //����������̵Ľڵ�
		   Queue<PointNode> queuepoint=new LinkedList<PointNode>();
		   ProduceSuc(q, suc_table, queuepoint);   //���ݺ�̱�����˵�ĺ�̷���queuepoint������
		   while(!queuepoint.isEmpty()){         //�ж϶����Ƿ�Ϊ��
			   PointNode ptem=queuepoint.poll();
			   if(!DM.containsValue(ptem)){
				   ptem.setID(ptem.getID()+1);
				   qpoint.offer(ptem);
				   DM.forcePut(indexOfPoint, ptem);
				   indexOfPoint++;
			   }else{
				   PointNode PN=DM.get(inverse.get(ptem));
				   PN.setID(PN.getID()+1);
			   }
		   }
		 }
	   return DM;
	   
	   
}
   public static void ProduceSuc(PointNode point,List<SucTable> suc_table,Queue<PointNode> queuepoint){
	   int[] pold=new int[suc_table.size()];
	   int[] pnew;
	   PointNode pn;
	   pold=point.getPoint();
	   for(int i=0;i<4;i++){
		   int flag=1;
		   pnew=new int[suc_table.size()];
		   pn=new PointNode();
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
		    pn.setID(0);
		    queuepoint.offer(pn);
		   }
		   
		 }

   }

}
