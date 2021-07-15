/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhang;
import java.sql.*;
import java.sql.Connection; 
import javax.swing.*;
import javax.swing.table.DefaultTableModel; 

public class QLHANG extends JFrame{
    static ConnectionDB kn = new ConnectionDB();
    public static void main(String[] args) {
        // TODO code application logic here
        Connection cn = kn.getConnectionDB();
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select MaSP,TenSP,TenLoaiSP from SanPham s inner join LoaiSanPham l on s.MaLoaiSP = l.MaLoaiSP ";
        
        try {
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                System.out.println("MaSP: "+ rs.getString(1) +"\t TenSP:"+ rs.getString(2)+"\tTenLoaiSP: "+ rs.getString(3));
                
            }
        } catch (Exception e) {
            System.out.println("Lỗi gì đó rồi"+e);
        }
        
    }
    
    private Connection connect = null;
    private JTable jtable = new JTable();
    private DefaultTableModel tableModel = new DefaultTableModel(); 
    public QLHANG() throws SQLException{
        String []colsName = {"Mã SP", "Tên SP", "Tên Loai Sp"};
        tableModel.setColumnIdentifiers(colsName); 
        jtable.setModel(tableModel);
        initComponent();	
        connectSQL();	
        updateData(view());
    }
    
    public void updateData(ResultSet result){ 
        try {
             while(result.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
             String rows[] = new String[3];
             rows[0] = result.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã sp) 
             rows[1] = result.getString(2);
             rows[2] = result.getString(3);
             tableModel.addRow(rows);

                                }
            } catch (SQLException e) { e.printStackTrace();}
}

    public void initComponent(){ 
        this.setSize(400, 200);
        JScrollPane scroll = JTable.createScrollPaneForTable(jtable); 
        this.add(scroll); 
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
}

    public ResultSet view(){
        ResultSet result = null;
        String sql = "SELECT * FROM Sanpham"; 
        try {
        Statement statement = (Statement) connect.createStatement();
        return statement.executeQuery(sql);
             } catch (SQLException e) { e.printStackTrace();}
        return result;
}

    private void connectSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
