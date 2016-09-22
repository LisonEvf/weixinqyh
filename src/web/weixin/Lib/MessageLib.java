package web.weixin.Lib;

import web.Model.Asset;

public class MessageLib {
	public static String AssetDescription(Asset asset){
		String Description = 
				"编号："+asset.getAssetNumber()+
				"\n型号："+asset.getModel()+
				"\n所在部门："+asset.getUseDepartment()+
				"\n借用人："+asset.getWarehouseman();
		return Description;
		
	}

}
