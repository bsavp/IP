package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModelProperty;

public class Cars {
	@ApiModelProperty(required = true)
	
	private String model;
	private String color;
	private Sting price;
	private String engine;
	
	public Cars(){
		
	}
	
	public Cars(String model, String color, String price, String engine){
		super();
		this.model = model;
		this.color = color;
		this.price = price;
		this.engine = engine;
	}
	
	
	public String getModel() {
		return model;
	}

	public void setModel(String model ) {
		this.model = model;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color ) {
		this.color = color;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price ) {
		this.price = price;
	}
	
	public String getEngine() {
		return color;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}
}
