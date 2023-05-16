import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//Skeleton of the game, just needs a touch up
public class Main extends Application 
{	
	boolean key = false;
	boolean moving = false;
	Tile tile;
	ArrayList<Tile> gameScreen = new ArrayList<Tile>();
	
	@Override
	public void start(Stage primaryStage) 
	{	
		try 
		{				
			Pane root = new Pane();
			
			//Background
			Rectangle background = new Rectangle(10, 10, Color.rgb(173, 157, 150));
			background.toBack();
			root.getChildren().add(background);
			
			//Slots
			for(int r = 0; r < 4; r++)
			{
				for(int c = 0; c < 4; c++)
				{
					Rectangle slots = new Rectangle(140, 140, Color.rgb(189, 177, 165));
					root.getChildren().add(slots);
					slots.setTranslateX(17.5 + 155 * r);
					slots.setTranslateY(17.5 + 155 * c);
				}
			}
			
			//Set tiles
			Controller controller = new Controller();
			
			for(int r = 0; r < 4; r++)
			{
				for(int c = 0; c < 4; c++)
				{
					if(controller.tiles[r][c] == null)
					{
						System.out.print("x ");
					}
					else
					{
						System.out.print("o ");
						
						root.getChildren().addAll(controller.tiles[r][c].getTile(), controller.tiles[r][c].getText());
						controller.tiles[r][c].getTile().setTranslateX(17.5 + 155 * c);
						controller.tiles[r][c].getTile().setTranslateY(17.5 + 155 * r);
						controller.tiles[r][c].getText().setTranslateX(60 + 155 * c);
						controller.tiles[r][c].getText().setTranslateY(115 + 155 * r);
						
						gameScreen.add(controller.tiles[r][c]);
					}
				}
				System.out.println("");
			}
			
			//Set scene
			Scene scene = new Scene(root,640,640);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//Gets key press
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
			{
				@Override
				public void handle(KeyEvent event)
				{
					if(!key)
					{
						switch (event.getCode())
						{
						case UP:
							
							key = true;
							System.out.println("UP");
							
							for(int r = 0; r < 4; r++)
							{
								for(int c = 0; c < 4; c++)
								{
									if(r > 0 && controller.tiles[r][c] != null) 
									{
										tile = controller.tiles[r][c];
										moving = true;
										
										while(moving)
										{
											if(controller.getIndexR(tile) - 1 != -1 && controller.tiles[controller.getIndexR(tile) - 1][controller.getIndexC(tile)] == null)
											{
												controller.tiles[controller.getIndexR(tile) - 1][controller.getIndexC(tile)] = tile;
												controller.tiles[r][c] = null;
												System.out.println("Moved to: " + controller.getIndexR(tile) + " " + controller.getIndexC(tile));
												
												if(r != 0)
												{
													r--;
													tile = controller.tiles[r][c];
												}
											}
											else
											{
												moving = false;
												System.out.println("Stopped at: " + controller.getIndexR(tile) + " " + controller.getIndexC(tile));
												
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getTile().setTranslateX(17.5 + 155 * controller.getIndexC(tile));
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getTile().setTranslateY(17.5 + 155 * controller.getIndexR(tile));
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getText().setTranslateX(60 + 155 * controller.getIndexC(tile));
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getText().setTranslateY(115 + 155 * controller.getIndexR(tile));
												
												if(controller.getIndexR(tile) != 0 && controller.tiles[controller.getIndexR(tile) - 1][controller.getIndexC(tile)] != null && controller.tiles[controller.getIndexR(tile) - 1][controller.getIndexC(tile)].getNum() == tile.getNum())
												{
													controller.tiles[controller.getIndexR(tile) - 1][controller.getIndexC(tile)].setNum(tile.getNum() * 2);
													controller.tiles[controller.getIndexR(tile) - 1][controller.getIndexC(tile)].setText();
													controller.tiles[controller.getIndexR(tile) - 1][controller.getIndexC(tile)].setColor();
													
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getTile().setVisible(false);
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getText().setVisible(false);
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)] = null;
												}
											}
										}
										tile = null;
									}
								}
							}
							
							break;
						case DOWN:
							
							key = true;
							System.out.println("DOWN");
							
							for(int r = 3; r > -1; r--)
							{
								for(int c = 0; c < 4; c++)
								{
									if(r < 3 && controller.tiles[r][c] != null) 
									{
										tile = controller.tiles[r][c];
										moving = true;
										
										while(moving)
										{
											if(controller.getIndexR(tile) + 1 != 4 && controller.tiles[controller.getIndexR(tile) + 1][controller.getIndexC(tile)] == null)
											{
												controller.tiles[controller.getIndexR(tile) + 1][controller.getIndexC(tile)] = tile;
												controller.tiles[r][c] = null;
												System.out.println("Moved to: " + controller.getIndexR(tile) + " " + controller.getIndexC(tile));
												
												if(r != 3)
												{
													r++;
													tile = controller.tiles[r][c];
												}
											}
											else
											{
												moving = false;
												System.out.println("Stopped at: " + controller.getIndexR(tile) + " " + controller.getIndexC(tile));
												
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getTile().setTranslateX(17.5 + 155 * controller.getIndexC(tile));
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getTile().setTranslateY(17.5 + 155 * controller.getIndexR(tile));
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getText().setTranslateX(60 + 155 * controller.getIndexC(tile));
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getText().setTranslateY(115 + 155 * controller.getIndexR(tile));
												
												if(controller.getIndexR(tile) != 3 && controller.tiles[controller.getIndexR(tile) + 1][controller.getIndexC(tile)] != null && controller.tiles[controller.getIndexR(tile) + 1][controller.getIndexC(tile)].getNum() == tile.getNum())
												{
													controller.tiles[controller.getIndexR(tile) + 1][controller.getIndexC(tile)].setNum(tile.getNum() * 2);
													controller.tiles[controller.getIndexR(tile) + 1][controller.getIndexC(tile)].setText();
													controller.tiles[controller.getIndexR(tile) + 1][controller.getIndexC(tile)].setColor();
													
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getTile().setVisible(false);
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getText().setVisible(false);
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)] = null;
												}
											}
										}
										tile = null;
									}
								}
							}
							
							break;
						case LEFT:
							
							key = true;
							System.out.println("LEFT");
							
							for(int c = 0; c < 4; c++)
							{
								for(int r = 0; r < 4; r++)
								{
									if(c > 0 && controller.tiles[r][c] != null) 
									{
										tile = controller.tiles[r][c];
										moving = true;
										
										while(moving)
										{
											if(controller.getIndexC(tile) - 1 != -1 && controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) - 1] == null)
											{
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) - 1] = tile;
												controller.tiles[r][c] = null;
												System.out.println("Moved to: " + controller.getIndexR(tile) + " " + controller.getIndexC(tile));
												
												if(c != 0)
												{
													c--;
													tile = controller.tiles[r][c];
												}
											}
											else
											{
												moving = false;
												System.out.println("Stopped at: " + controller.getIndexR(tile) + " " + controller.getIndexC(tile));
												
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getTile().setTranslateX(17.5 + 155 * controller.getIndexC(tile));
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getTile().setTranslateY(17.5 + 155 * controller.getIndexR(tile));
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getText().setTranslateX(60 + 155 * controller.getIndexC(tile));
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getText().setTranslateY(115 + 155 * controller.getIndexR(tile));
												
												if(controller.getIndexC(tile) != 0 && controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) - 1] != null && controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) - 1].getNum() == tile.getNum())
												{
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) - 1].setNum(tile.getNum() * 2);
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) - 1].setText();
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) - 1].setColor();
													
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getTile().setVisible(false);
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getText().setVisible(false);
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)] = null;
												}
											}
										}
										tile = null;
									}
								}
							}
							
							break;
						case RIGHT:		
							
							key = true;
							System.out.println("RIGHT");
							
							for(int c = 3; c > -1; c--)
							{
								for(int r = 0; r < 4; r++)
								{
									if(c < 3 && controller.tiles[r][c] != null) 
									{
										tile = controller.tiles[r][c];
										moving = true;
										
										while(moving)
										{
											if(controller.getIndexC(tile) + 1 != 4 && controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) + 1] == null)
											{
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) + 1] = tile;
												controller.tiles[r][c] = null;
												System.out.println("Moved to: " + controller.getIndexR(tile) + " " + controller.getIndexC(tile));
												
												if(c != 3)
												{
													c++;
													tile = controller.tiles[r][c];
												}
											}
											else
											{
												moving = false;
												System.out.println("Stopped at: " + controller.getIndexR(tile) + " " + controller.getIndexC(tile));
												
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getTile().setTranslateX(17.5 + 155 * controller.getIndexC(tile));
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getTile().setTranslateY(17.5 + 155 * controller.getIndexR(tile));
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getText().setTranslateX(60 + 155 * controller.getIndexC(tile));
												controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getText().setTranslateY(115 + 155 * controller.getIndexR(tile));
												
												if(controller.getIndexC(tile) != 3 && controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) + 1] != null && controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) + 1].getNum() == tile.getNum())
												{
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) + 1].setNum(tile.getNum() * 2);
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) + 1].setText();
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile) + 1].setColor();
													
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getTile().setVisible(false);
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)].getText().setVisible(false);
													controller.tiles[controller.getIndexR(tile)][controller.getIndexC(tile)] = null;
												}
											}
										}
										tile = null;
									}
								}
							}
													
							break;
						}
					}
					
					int count = 0;
					
					while(count < 2)
					{
						int row = (int) (Math.random() * 4);
						int col = (int) (Math.random() * 4);
						
						if(controller.tiles[row][col] == null)
						{
							controller.tiles[row][col] = new Tile();
							
							count++;
							
							root.getChildren().addAll(controller.tiles[row][col].getTile(), controller.tiles[row][col].getText());
							controller.tiles[row][col].getTile().setTranslateX(17.5 + 155 * col);
							controller.tiles[row][col].getTile().setTranslateY(17.5 + 155 * row);
							controller.tiles[row][col].getText().setTranslateX(60 + 155 * col);
							controller.tiles[row][col].getText().setTranslateY(115 + 155 * row);
						}
						else if(controller.checkTiles())
						{
							count = 2;
						}
						else if(controller.checkFull())
						{
							count = 2;
						}
					}
					
					for(int r = 0; r < 4; r++)
					{
						for(int c = 0; c < 4; c++)
						{
							if(controller.tiles[r][c] == null)
							{
								System.out.print("x ");
							}
							else
							{
								System.out.print("o ");
							}
						}
						System.out.println("");
					}
				}
			});
			scene.setOnKeyReleased(new EventHandler<KeyEvent>()
			{
				@Override
				public void handle(KeyEvent event)
				{
					key = false;
				}
			}); 
			
			
			//Sliding and sizing
			AnimationTimer timer = new AnimationTimer() 
			{
				@Override
				public void handle(long now) 
				{
					background.setWidth(scene.getWidth());
					background.setHeight(scene.getHeight());
				}
			};
				
			timer.start();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}