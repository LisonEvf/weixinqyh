package web.Dao.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import web.Dao.AssetDao;
import web.Model.Asset;

@Repository
public class AssetDaoImpl implements AssetDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Asset> SelectAllAsset() {
		String sql = "select * from equipment";
		return (List<Asset>)jdbcTemplate.query(sql, new BeanPropertyRowMapper<Asset>(Asset.class));
		
	}
	
	@Override
	public List<Asset> SelectAsset(String keyword) {
		String sql = "select * from equipment where concat (assetName,model,useDepartment,warehouseman,specification) like '%"+keyword+"%'";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Asset>(Asset.class));
	}
}
