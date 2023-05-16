
public class Controller 
{
	Tile[][] tiles = new Tile[4][4];
	
	int row;
	int col;
	int count;
	
	public Controller()
	{
		for(int r = 0; r < tiles.length; r++)
		{
			for(int c = 0; c < tiles[0].length; c++)
			{
				tiles[r][c] = null;
			}
		}
		Moved();
	}
	
	public void Moved()
	{
		count = 0;
		
		while(count < 2)
		{
			row = (int) (Math.random() * 4);
			col = (int) (Math.random() * 4);
			
			if(tiles[row][col] == null)
			{
				tiles[row][col] = new Tile();
				
				count++;
			}
			else if(checkTiles())
			{
				count = 2;
			}
		}
	}
	
	public boolean checkTiles()
	{
		count = 0;
		
		for(int r = 0; r < tiles.length; r++)
		{
			for(int c = 0; c < tiles[0].length; c++)
			{
				if(tiles[r][c] != null)
				{
					count++;
				}
			}
		}
		
		if(count == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkFull()
	{
		count = 0;
		
		for(int r = 0; r < tiles.length; r++)
		{
			for(int c = 0; c < tiles[0].length; c++)
			{
				if(tiles[r][c] == null)
				{
					count++;
				}
			}
		}
		
		if(count > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public int getIndexR(Tile t)
	{
		for(int r = 0; r < tiles.length; r++)
		{
			for(int c = 0; c < tiles[0].length; c++)
			{
				if(tiles[r][c] == t)
				{
					return r;
				}
			}
		}
		return 0;
	}
	
	public int getIndexC(Tile t)
	{
		for(int r = 0; r < tiles.length; r++)
		{
			for(int c = 0; c < tiles[0].length; c++)
			{
				if(tiles[r][c] == t)
				{
					return c;
				}
			}
		}
		return 0;
	}
}
