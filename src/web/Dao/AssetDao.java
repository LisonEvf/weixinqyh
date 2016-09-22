package web.Dao;

import java.util.List;

import web.Model.Asset;


public interface AssetDao {
	public List<Asset> SelectAllAsset();
	public List<Asset> SelectAsset(String keyword);

}
