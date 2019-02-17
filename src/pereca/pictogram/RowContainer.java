package pereca.pictogram;

import java.util.List;

import android.graphics.Bitmap;

public class RowContainer {
	
	private List<Bitmap> single_row;

	private String category;
	
	public RowContainer(List<Bitmap> single_row,String category) {
		super();
		this.single_row = single_row;
		this.setCategory(category);
	}

	public List<Bitmap> getSingle_row() {
		return single_row;
	}

	public void setSingle_row(List<Bitmap> single_row) {
		this.single_row = single_row;
	}
	
	public void replace(int index, Bitmap bitmap) {
		this.single_row.set(index, bitmap);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
