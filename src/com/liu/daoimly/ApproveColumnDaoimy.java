package com.liu.daoimly;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.liu.dao.ApproveColumnDao;
import com.liu.db.BaseDao;
import com.liu.util.DateUtil;
import com.liu.xutils.pojo.ApproveColumn;

public class ApproveColumnDaoimy implements ApproveColumnDao {
BaseDao baseDao=new BaseDao();
	public List<ApproveColumn> getApproveColumnBytypeid(int typeid) {
		List<Object> lists=baseDao.queryBySql("select * from approve_column where approvetypeid= "+typeid, ApproveColumn.class);
		
		List<ApproveColumn> data=new ArrayList<ApproveColumn>();
		ApproveColumn column;
		String name;
for (Object object : lists) {
	column=(ApproveColumn)object;


	


			data.add(column);
		}

		return data ;
	}
public boolean addApproveData(List<ApproveColumn> datas,int approveid){
String sql1="insert into approvedata (approveid,";
String sql2=" values("+approveid+",";
Object[] a=new Object[datas.size()];
ApproveColumn data=null;
String type=null;
String name=null;
String c=null;
for (int i = 0; i < datas.size(); i++) {
data=datas.get(i);
c=data.getData();
name=data.getShijicolumn();
	if(i==datas.size()-1){
		sql1+=name+")";
		sql2+="?)";
	}else{sql1+=name+",";
	sql2+="?,";
	}
	System.out.println(c+"=============c");
	 type=	name.split("\\_")[0];
	 if("varchar".equals(type)||"text".equals(type)){
		a[i]=c;
	 }else if("int".equals(type)){
		 a[i]=Integer.parseInt(c);
	 }
	 else if("datetime".equals(type)){
		 a[i]=DateUtil.stringToDate(c);

	 }else if("bit".equals(type)){
		 a[i]=Byte.parseByte(c);
	 }else if("decimal".equals(type)){
		 a[i]=Double.parseDouble(c);
	 }
	

}
System.out.println("sql1+sql2=============="+sql1+sql2);
      int i=baseDao.executeUpdateBypstmt(sql1+sql2, a);
if(i>0){
	return true;
}else{
      return false;           
}
	
}


}
