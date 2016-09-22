package web.weixin.Model.Menu;

public class Menu {
	private Button[] button;

	public Menu(Button ...button) {
		for(int i=0;i<button.length;i++){
			button[i].setKey(String.valueOf(i+1));
			if(button[i] instanceof SubButton){
				SubButton subbutton = (SubButton) button[i];
				subbutton.setkey();
			}	
		}
		this.button = button;
	}

	public Button[] getButton() {
		return button;
	}

}
