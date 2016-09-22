package web.weixin.Dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import web.Model.Asset;

public class WeixinDao {
	static JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
        WeixinDao.jdbcTemplate = jdbcTemplate;  
    }  
	
    public static Asset SelectAssetByID(String ID){
    	 String sql = "select * from equipment where assetNumber="+ID; 
         return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Asset>(Asset.class)); 
	}
    
    public static void DelAssetByID(String ID){
    	String sql = "delete from equipment where assetNumber="+ID; 
    	jdbcTemplate.update(sql);
    }
    
	public static List<Asset> SelectAsset(String keyword) {
		String sql = "select * from equipment where concat (assetName,model,useDepartment,warehouseman,specification) like '%"+keyword+"%'";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Asset>(Asset.class));
	}
}
