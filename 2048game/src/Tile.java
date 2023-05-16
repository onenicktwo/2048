import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Tile 
{
	int num;
	Rectangle tile = new Rectangle(140, 140);
	Text text = new Text();
	
	public Tile()
	{
		num = (int) (Math.random() * 3) + 1;
		
		if(num == 3)
		{
			num = 4;
		}
		
		if(num == 1)
		{
			num = 2;
		}
		
		setText();
		setColor();
	}
	
	public void setColor()
	{
		if(num > 2)
		{
			if(num > 4)
			{
				if(num > 8)
				{
					if(num > 16)
					{
						if(num > 32)
						{
							if(num > 64)
							{
								if(num > 128)
								{
									if(num > 256)
									{
										if(num > 512)
										{
											if(num > 1024)
											{
												if(num > 2048)
												{
													
												}
												else
												{
													tile.setFill(Color.rgb(237, 196, 0));
												}
											}
											else
											{
												tile.setFill(Color.rgb(234, 196, 61));
											}
										}
										else
										{
											tile.setFill(Color.rgb(238, 197, 79));
										}
									}
									else
									{
										tile.setFill(Color.rgb(238, 201, 94));
									}
								}
								else
								{
									tile.setFill(Color.rgb(241, 218, 116));
								}
							}
							else
							{
								tile.setFill(Color.rgb(243, 92, 66));
							}
						}
						else
						{
							tile.setFill(Color.rgb(246, 123, 92));
						}
					}
					else
					{
						tile.setFill(Color.rgb(246, 148, 101));
					}
				}
				else
				{
					tile.setFill(Color.rgb(241, 174, 122));
				}
			}
			else
			{
				tile.setFill(Color.rgb(237, 223, 197));
			}
		}
		else
		{
			tile.setFill(Color.rgb(237, 227, 217));
		}
	}
	
	public void setText()
	{
		text.setText("" + num);
		text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 75));
		
		if(num > 8)
		{
			text.setFill(Color.WHITE);
		}
		else
		{
			text.setFill(Color.rgb(119, 110, 101)); 
		}
	}
	
	public void setNum(int n)
	{
		num = n;
	}
	
	public int getNum()
	{
		return num;
	}
	
	public Rectangle getTile()
	{
		return tile;
	}
	
	public Text getText()
	{
		return text;
	}
}
