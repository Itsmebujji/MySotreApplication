package com.vineeth.mystore.repository;

import com.vineeth.mystore.entities.Product;
import com.vineeth.mystore.entities.Vendor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcRepoSample {

    private final JdbcTemplate jdbcTemplate;
    public final String sql = "SELECT * FROM vendors";

    public JdbcRepoSample(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Vendor> findAllUsers() {
        return jdbcTemplate.query(sql, (rs, rowNumber) -> {
            Vendor v=new Vendor();
            v.setVendorName(rs.getString("vendor_name"));
            v.setVendorEmail(rs.getString("vendor_email"));
            v.setVendorAddress(rs.getString("vendor_address"));
            v.setVendorPhone(rs.getString("vendor_phone"));
            return v;
        });
    }
}
