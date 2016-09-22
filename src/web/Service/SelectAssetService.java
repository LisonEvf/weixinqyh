package web.Service;

import org.springframework.web.servlet.ModelAndView;

public interface SelectAssetService {
	public ModelAndView SelectAsset(String asseturl,String keyword);
}
