package com.kangjiaqi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDUtil.getConnection();
            String sql = "select ename, sal from emp";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("ename") + " " + rs.getDouble("sal"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDUtil.close(conn, ps, rs);
        }
    }
}
