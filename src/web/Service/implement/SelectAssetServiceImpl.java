package web.Service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import web.Dao.AssetDao;
import web.Model.Asset;
import web.Service.SelectAssetService;

@Service
public class SelectAssetServiceImpl implements SelectAssetService{

	@Autowired
	private AssetDao assetDao;
	@Override
	public ModelAndView SelectAsset(String asseturl,String keyword) {
		if(keyword.equals("")){
			List<Asset> list = assetDao.SelectAllAsset();
			return new ModelAndView(asseturl,"list",list);
		}else{
			List<Asset> list = assetDao.SelectAsset(keyword);
			
			if(!list.isEmpty())
			return new ModelAndView(asseturl,"list",list);
			else
				return new ModelAndView(asseturl);
		}
//		return new ModelAndView(asseturl);
		
	}

}
