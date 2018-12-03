package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.BuyDataBeans;
import beans.ItemDataBeans;

public class Datadao {

	 public List<BuyDataBeans> findAll() {
	        Connection conn = null;
	        List<BuyDataBeans> dataList = new ArrayList<BuyDataBeans>();

	        try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	         // SELECT文を準備
	            // TODO: 未実装：管理者以外を取得するようSQLを変更する
	            String sql = "select*from t_buy inner join m_delivery_method on t_buy.delivery_method_id = m_delivery_method.id order by t_buy.id desc;";

	             // SELECTを実行し、結果表を取得
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            // 結果表に格納されたレコードの内容を
	            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                int userId = rs.getInt("user_id");
	                int totalPrice = rs.getInt("total_price");
	                int deliveryMethodId = rs.getInt("delivery_method_id");
	                Timestamp createDate = rs.getTimestamp("create_date");

	                String name=rs.getString("name");
	                int Price = rs.getInt("price");

	                BuyDataBeans data = new BuyDataBeans(id, userId, totalPrice, deliveryMethodId, createDate,name,Price);

	                dataList.add(data);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            // データベース切断
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    return null;
	                }
	            }
	        }
	        return dataList;
	    }


	 public List<ItemDataBeans> findData(String id) {
	        Connection conn = null;
	        List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

	        try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	         // SELECT文を準備
	            // TODO: 未実装：管理者以外を取得するようSQLを変更する
	            String sql = "select*from t_buy_detail inner join m_item on t_buy_detail.item_id = m_item.id WHERE buy_id="+id+";";

	             // SELECTを実行し、結果表を取得
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            // 結果表に格納されたレコードの内容を
	            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
	            while (rs.next()) {
	                int Id = rs.getInt("id");
	                int buyId = rs.getInt("buy_id");
	                int itemId = rs.getInt("item_id");
	                String name=rs.getString("name");
	                String detail=rs.getString("detail");
	                int Price = rs.getInt("price");
	                String fileName=rs.getString("file_name");

	                ItemDataBeans item = new ItemDataBeans(Id,name,detail,Price ,fileName,buyId, itemId);

	                itemList.add(item);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            // データベース切断
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    return null;
	                }
	            }
	        }
	        return itemList;
	    }

	 public List<BuyDataBeans> find(String d) {
	        Connection conn = null;
	        List<BuyDataBeans> List = new ArrayList<BuyDataBeans>();

	        try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	         // SELECT文を準備
	            // TODO: 未実装：管理者以外を取得するようSQLを変更する
	            String sql = "select*from t_buy inner join m_delivery_method on t_buy.delivery_method_id = m_delivery_method.id WHERE t_buy.id="+d+"";

	             // SELECTを実行し、結果表を取得
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            // 結果表に格納されたレコードの内容を
	            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                int userId = rs.getInt("user_id");
	                int totalPrice = rs.getInt("total_price");
	                int deliveryMethodId = rs.getInt("delivery_method_id");
	                Timestamp createDate = rs.getTimestamp("create_date");
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
	                sdf.format(createDate);
	                String name=rs.getString("name");
	                int Price = rs.getInt("price");

	                BuyDataBeans dat = new BuyDataBeans(id, userId, totalPrice, deliveryMethodId, createDate,name,Price);

	                List.add(dat);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            // データベース切断
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    return null;
	                }
	            }
	        }
	        return List;
	    }

}

