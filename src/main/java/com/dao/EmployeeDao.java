package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.connection.JDBCConnection;
import com.javabeans.Employee;

public class EmployeeDao {
	public boolean Insert(Employee emp) {
		String sql = "insert into emp1(empId,empName,empEmail) values(?,?,?)";
//		String sql="insert into emp1(empId,empName,empEmail,loginDate,logoutDate) values(?,?,?,current_time,current_date);";
		try {
			PreparedStatement st = JDBCConnection.getconnect().prepareStatement(sql);
			st.setInt(1, emp.getEmpId());
//			st.setString(2, emp.getUniqueCode());
			st.setString(2, emp.getEmpName());
			st.setString(3, emp.getEmpEmail());

			return st.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateEmpLogin(int empId) {
		String sql="update emp1 set logindate=now() where empId=?"; 
		try {
			PreparedStatement p=JDBCConnection.getconnect().prepareStatement(sql);
			p.setInt(1,empId);
			return p.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	public boolean updateEmpLogout(int empId) {
		String sql="update emp1 set logoutdate=now() where empId=?"; 
		try {
			PreparedStatement p=JDBCConnection.getconnect().prepareStatement(sql);
			p.setInt(1,empId);
			return p.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
//	
//	 public String getUniqueCode() {
//	        String uniqueCode=UUID.randomUUID().toString();
//	        String sql="select EXISTS(select uniquecode from emp1 where uniquecode=?) as status;";
//	         try
//	         {
//	            int currentUniqueCode = 0;
//	            PreparedStatement sts = JDBCConnection.getconnect().prepareStatement(sql);
//	            sts.setString(1, uniqueCode);
//	            if(sts.executeQuery()!=null) {
//	                ResultSet rs=sts.executeQuery();
//	                
//	                while(rs.next()) {
//	                    currentUniqueCode=rs.getInt("status");
////	                    System.out.println(currentUniqueCode);
//	                }
//	                if(currentUniqueCode==1) {
//	                    getUniqueCode();
//	                }
//	            }
//	         }
//	         catch (Exception e) {
//				e.printStackTrace();
//			}
//	         return uniqueCode;
//	 }

	public  Employee checkUser(int empId) {
		String sql = "select * from emp1 where empId=?";
//		Employee reg = null;
		Employee  e = new Employee ();
		try {
			PreparedStatement st = JDBCConnection.getconnect().prepareStatement(sql);			
			st.setInt(1,empId);     ///////////////////
			ResultSet res = st.executeQuery();
			
			while (res.next()) {
				
				e.setEmpId(res.getInt("empId"));
				e.setEmpName(res.getString("empName"));
				e.setEmpEmail(res.getString("empEmail"));
			}

		} catch (Exception x) {
			x.printStackTrace();
		}
		return e;
	}
	
	public boolean delete(int empId) {
        String sql="delete from emp1 where empId=?";
        Employee  e = new Employee ();
        try {
            PreparedStatement st=JDBCConnection.getconnect().prepareStatement(sql);
            st.setInt(1,empId);
            return st.executeUpdate()>0;
        } catch (SQLException x) {
    
            x.printStackTrace();
        }
        
        return false;
    }
//	 public static boolean InsertLogindetails(Employee emp)
//     {
//        String sql="insert into emp1(uniquecode,empId,loginDate,logoutDate) values(?,?,current_time,current_date);";
//         try
//         {
//            PreparedStatement sts = JDBCConnection.getconnect().prepareStatement(sql);
//            sts.setString(1, emp.getUniqueCode());
//            sts.setInt(2,emp.getEmpId());
//             
//        //    sts.setInt(3,s.getIntime());
//            return sts.executeUpdate()>0;
//        }
//         catch (SQLException e)
//         {
//            e.printStackTrace();
//        }
//         return false;
//     }
//	public static boolean InsertLogoutdetails(String uniqueCode)
//    {
//       String sql="update emp1 set logoutDate=current_date() where uniquecode=?";
//        try
//        {
//           PreparedStatement sts = JDBCConnection.getconnect().prepareStatement(sql);
//           sts.setString(1, uniqueCode);
//           
//            
//       //    sts.setInt(3,s.getIntime());
//           return sts.executeUpdate()>0;
//       }
//        catch (SQLException e)
//        {
//           e.printStackTrace();
//       }
//        return false;
//    }

	public List<Employee> AllUser() {
		String sql = "select * from emp1 ";
		List<Employee> listuser = new ArrayList<>();
		
		try {
			PreparedStatement st = JDBCConnection.getconnect().prepareStatement(sql);
//			Employee reg = null;
//			st.setString(1, user);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				int empId=res.getInt("empId");
				String empName=res.getString("empName");
				String empEmail=res.getString("empEmail");
//				String uniqueCode=res.getString("eId");
				Employee e=new Employee(empId,empName,empEmail);
				listuser.add(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listuser;
}
}
